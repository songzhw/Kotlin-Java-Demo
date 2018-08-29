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