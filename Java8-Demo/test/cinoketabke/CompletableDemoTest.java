package cinoketabke;

import com.sun.xml.internal.ws.util.CompletedFuture;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;

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
