package cinoketabke;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.CompletableFuture;

public class CompletableDemoTest {

    // getNow() 返回完成后的结果, 在这就是"first". 若还没完成就返回传入的null(默认值)
    @Test
    public void testCopmleted(){
        // 这是新建一个已完成的任务(completed), 所以下面的isDone()是true
        CompletableFuture future = CompletableFuture.completedFuture("first");
        assertTrue(future.isDone());
        assertEquals("first", future.getNow(null));
    }
}