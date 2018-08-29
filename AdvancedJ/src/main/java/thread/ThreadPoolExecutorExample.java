package thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        createAndRunPoolForQueue(new ArrayBlockingQueue<Runnable>(3), "Bounded");
        createAndRunPoolForQueue(new LinkedBlockingDeque<>(), "Unbounded");
        createAndRunPoolForQueue(new SynchronousQueue<Runnable>(), "Direct hand-off");
    }

    private static void createAndRunPoolForQueue(BlockingQueue<Runnable> queue, String msg) {
        System.out.println("---- " + msg + " queue instance = " + queue.getClass() + " -------------");

        ThreadPoolExecutor e = new ThreadPoolExecutor(2, 5, Long.MAX_VALUE, TimeUnit.NANOSECONDS, queue);

        for (int i = 0; i < 10; i++) {
            try {
                e.execute(new Task());
                printStatus(i + 1, e);
            } catch (RejectedExecutionException ex) {
                System.out.println("Task rejected = " + (i + 1));
            }
        }

        e.shutdownNow();

        System.out.println("--------------------\n");
    }

    private static void printStatus(int taskSubmitted, ThreadPoolExecutor executor) {
        StringBuilder sb = new StringBuilder();
        sb.append("core = 2, max = 5, poolSize = ")
                .append(executor.getPoolSize())
                .append(", queueSize = ")
                .append(executor.getQueue() .size())
                .append(", queueRemainingCapacity = ")
                .append(executor.getQueue().remainingCapacity())
                .append(", totalTasksSubmitted = ")
                .append(taskSubmitted);

        System.out.println(sb.toString());
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);  //1000s, 20min左右
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}

/*
    [createAndRunPoolForQueue(new ArrayBlockingQueue<Runnable>(3), "Bounded");]

core = 2, max = 5, poolSize = 1, queueSize = 0, queueRemainingCapacity = 3, totalTasksSubmitted = 1
core = 2, max = 5, poolSize = 2, queueSize = 0, queueRemainingCapacity = 3, totalTasksSubmitted = 2
core = 2, max = 5, poolSize = 2, queueSize = 1, queueRemainingCapacity = 2, totalTasksSubmitted = 3
core = 2, max = 5, poolSize = 2, queueSize = 2, queueRemainingCapacity = 1, totalTasksSubmitted = 4
core = 2, max = 5, poolSize = 2, queueSize = 3, queueRemainingCapacity = 0, totalTasksSubmitted = 5
core = 2, max = 5, poolSize = 3, queueSize = 3, queueRemainingCapacity = 0, totalTasksSubmitted = 6
core = 2, max = 5, poolSize = 4, queueSize = 3, queueRemainingCapacity = 0, totalTasksSubmitted = 7
core = 2, max = 5, poolSize = 5, queueSize = 3, queueRemainingCapacity = 0, totalTasksSubmitted = 8
Task rejected = 9
Task rejected = 10
 */


/*
    [createAndRunPoolForQueue(new LinkedBlockingDeque<>(), "Unbounded");]
---- Unbounded queue instance = class java.util.concurrent.LinkedBlockingDeque -------------
core = 2, max = 5, poolSize = 1, queueSize = 0, queueRemainingCapacity = 2147483647, totalTasksSubmitted = 1
core = 2, max = 5, poolSize = 2, queueSize = 0, queueRemainingCapacity = 2147483647, totalTasksSubmitted = 2
core = 2, max = 5, poolSize = 2, queueSize = 1, queueRemainingCapacity = 2147483646, totalTasksSubmitted = 3
core = 2, max = 5, poolSize = 2, queueSize = 2, queueRemainingCapacity = 2147483645, totalTasksSubmitted = 4
core = 2, max = 5, poolSize = 2, queueSize = 3, queueRemainingCapacity = 2147483644, totalTasksSubmitted = 5
core = 2, max = 5, poolSize = 2, queueSize = 4, queueRemainingCapacity = 2147483643, totalTasksSubmitted = 6
core = 2, max = 5, poolSize = 2, queueSize = 5, queueRemainingCapacity = 2147483642, totalTasksSubmitted = 7
core = 2, max = 5, poolSize = 2, queueSize = 6, queueRemainingCapacity = 2147483641, totalTasksSubmitted = 8
core = 2, max = 5, poolSize = 2, queueSize = 7, queueRemainingCapacity = 2147483640, totalTasksSubmitted = 9
core = 2, max = 5, poolSize = 2, queueSize = 8, queueRemainingCapacity = 2147483639, totalTasksSubmitted = 10
(备注: Integer.MAX_VALUE就是2147483647)
 */


/*
使用SynchronousQueue的目的就是保证“对于提交的任务，如果有空闲线程，则使用空闲线程来处理；否则新建一个线程来处理任务”。
如果应用程序确实需要比较大的工作队列容量，而又想避免无界工作队列可能导致的问题，不妨考虑SynchronousQueue。SynchronousQueue实现上并不使用缓存空间。


    [createAndRunPoolForQueue(new SynchronousQueue<Runnable>(), "Direct hand-off");]
---- Direct hand-off queue instance = class java.util.concurrent.SynchronousQueue -------------
core = 2, max = 5, poolSize = 1, queueSize = 0, queueRemainingCapacity = 0, totalTasksSubmitted = 1
core = 2, max = 5, poolSize = 2, queueSize = 0, queueRemainingCapacity = 0, totalTasksSubmitted = 2
core = 2, max = 5, poolSize = 3, queueSize = 0, queueRemainingCapacity = 0, totalTasksSubmitted = 3
core = 2, max = 5, poolSize = 4, queueSize = 0, queueRemainingCapacity = 0, totalTasksSubmitted = 4
core = 2, max = 5, poolSize = 5, queueSize = 0, queueRemainingCapacity = 0, totalTasksSubmitted = 5
Task rejected = 6
Task rejected = 7
Task rejected = 8
Task rejected = 9
Task rejected = 10
 */