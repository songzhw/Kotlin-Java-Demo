package ca.six.demo.juc;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("[main] thread = "+Thread.currentThread().getName());

        Callable<Integer> callable = () -> {
            System.out.println("[callable] : thread = "+Thread.currentThread().getName());
            return 23;
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(callable);
        int result = future.get();
        System.out.println("[main] result = "+result);

        FutureTask<Integer> f2 = new FutureTask<Integer>(callable){
            @Override
            protected void done() {
                // TODO when done, do soemthing
            }
        };
        executor.execute(f2);

    }
}

/*
[main] thread = main
[callable] : thread = pool-1-thread-1
[main] result = 23
 */