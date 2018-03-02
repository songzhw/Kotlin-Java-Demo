package cinoketabke;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
