package cinoketabke;


import functions.User;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableDemoTest {

    // getNow() 返回完成后的结果, 在这就是"first". 若还没完成就返回传入的null(默认值)
    @Test
    public void testCopmleted() {
        // 这是新建一个已完成的任务(completed), 所以下面的isDone()是true
        CompletableFuture future = CompletableFuture.completedFuture("first");
        assertTrue(future.isDone());
        assertEquals("first", future.getNow(null));
    }

    @Test
    public void testAsync() {
        CompletableFuture future = CompletableFuture.runAsync(() -> {
            System.out.println("testAsync() : 01 Thread = " + Thread.currentThread().getName());
            SystemClock.sleep(200);
        });

        System.out.println("testAsync() : 02 Thread = " + Thread.currentThread().getName());
        assertFalse((future.isDone()));
        SystemClock.sleep(340);
        assertTrue(future.isDone());
    }
    /* 注意执行顺序
        testAsync() : 02 Thread = main
        testAsync() : 01 Thread = ForkJoinPool.commonPool-worker-1
     */


    // then是指上一阶段(即完成后得到msg), apply是用上一阶段的结果来接着做下一阶段的事
    @Test
    public void testStages() {
        CompletableFuture future =
            CompletableFuture.completedFuture("msg")
                .thenApply(msg -> {
                    System.out.println("testStages() : 01 Thread = " + Thread.currentThread().getName());
                    return msg.toUpperCase();
                });  //.thenApply(String::toUpperCase)也行

        System.out.println("testStages() : 02 Thread = " + Thread.currentThread().getName());
        assertEquals("MSG", future.getNow(null));
    }
    /*
        因为都在main线程中, 所以等执行到getNow(), 这个future其实已经完成了
        testStages() : 01 Thread = main
        testStages() : 02 Thread = main
    */




    @Test
    public void testStagesAsync() {
        CompletableFuture future =
            CompletableFuture.completedFuture("msg")
                .thenApplyAsync(msg -> {
                    System.out.println("testStagesAsync() : 01 Thread = " + Thread.currentThread().getName());
                    SystemClock.sleep(200);
                    return msg.toUpperCase();
                });  //.thenApply(String::toUpperCase)也行

        System.out.println("testStagesAsync() : 02 Thread = " + Thread.currentThread().getName());
        assertNull(future.getNow(null)); //为null, 是因为这时async还没有完成嘛.

        assertEquals("MSG", future.join()); //类似Thread.join(), 等你完成, 这时能得到结果
    }

    /* 注意执行顺序
        testStagesAsync() : 02 Thread = main
        testStagesAsync() : 01 Thread = ForkJoinPool.commonPool-worker-1
    */



    // thenApplyAsync(function, executor)还可以指定线程池
    private static int count = 0;
    @Test
    public void testWithExecutor() {
        ExecutorService executor = Executors.newFixedThreadPool(3, runnable -> {
            count++;
            return new Thread(runnable, "mine" + count);
        });

        CompletableFuture future =
            CompletableFuture.completedFuture("pool")
                .thenApplyAsync(str -> {
                    assertTrue(Thread.currentThread().getName().startsWith("mine"));
                    SystemClock.sleep(200);
                    return str.toUpperCase();
                }, executor);

        assertEquals("not finished", future.getNow("not finished"));
        assertEquals("POOL", future.join());

    }



    @Test
    public void testConsumeLastResult(){
        StringBuilder sb = new StringBuilder();
        CompletableFuture.completedFuture("tmp")
            .thenAccept(str -> sb.append(str)); //注意thenAccept()的返回值不是一个CompletableFuture了, 而是void
        assertTrue("empty result", sb.length() > 0); //若第二参condition为false, 就提示第一参

        // thenAcceptAsync()就是异步执行
    }


    @Test
    public void testEither(){
        String msg = "input";
        CompletableFuture job1 = CompletableFuture.completedFuture(msg)
                .thenApplyAsync(str -> delayedUpperCase(str));
        CompletableFuture job2 = CompletableFuture.completedFuture(msg)
                .thenApplyAsync(str -> delayedLowerCase(str));
        CompletableFuture result = job1.applyToEither(job2, str -> str + " (after)");

        assertEquals("INPUT (after)", result.join());
        // job1耽误了150ms, job2耽误了220ms. 所以自然是job1先完成, 所以就是"INPUT"了.
    }

    @Test
    public void acceptEither(){
        String msg = "input";
        StringBuilder sb = new StringBuilder();

        CompletableFuture job1 = CompletableFuture.completedFuture(msg)
                .thenApplyAsync(str -> delayedUpperCase(str));
        CompletableFuture job2 = CompletableFuture.completedFuture(msg)
                .thenApplyAsync(str -> delayedLowerCase(str));
        CompletableFuture result = job1.acceptEither(job2, str -> sb.append(str + " (accept)")); //即无返回值了

        assertEquals("", sb.toString()); //没执行完, 自然是空字符串

        result.join();
        assertEquals("INPUT (accept)", sb.toString());
        // job1耽误了150ms, job2耽误了220ms. 所以自然是job1先完成, 所以就是"INPUT"了.

    }

    @Test
    public void applyBoth(){
        String msg = "input";
        StringBuilder sb = new StringBuilder();

        CompletableFuture job1 = CompletableFuture.completedFuture(msg)
                .thenApply(str -> delayedUpperCase(str));
        CompletableFuture job2 = CompletableFuture.completedFuture(msg)
                .thenApply(str -> delayedLowerCase(str));
        job1.runAfterBoth(job2, () -> sb.append("done"));

        System.out.println("szw "+sb.toString());
    }
    /*
        delay 150ms upper case
        delay 220ms lower case
        szw done
     */


    @Test
    public void testThenCompose(){
        String str = "msg";
        CompletableFuture future = CompletableFuture.completedFuture(str)
                .thenApply(s -> delayedUpperCase(s))
                .thenCompose(upper ->   /*thenCompose(): Returns a new CompletionStage that, when this stage completes normally, is executed with this stage as the argument to the supplied function. */
                    CompletableFuture.completedFuture(str)
                            .thenApply(s -> delayedLowerCase(s))
                            .thenApply(s -> upper + s)

                );

        assertEquals("MSGmsg", future.join());
    }



//    @Test
//    public void test(){
//        users().thenCompose()
//
//        List<User> updatedUsers = users.stream()
//                .map(user -> {
//
//                    return user;
//                })
//                .collect(Collectors.toList());
//
//    }
//
//    private CompletionStage<List<User>> users(){
//        return null;
//    }




    private String delayedUpperCase(String in){
        SystemClock.sleep(150);
        System.out.println("delay 150ms upper case");
        return in.toUpperCase();
    }

    private String delayedLowerCase(String in){
        SystemClock.sleep(220);
        System.out.println("delay 220ms lower case");
        return in.toLowerCase();
    }

}

class SystemClock {
    static void sleep(long millsecond) {
        try {
            Thread.sleep(millsecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
