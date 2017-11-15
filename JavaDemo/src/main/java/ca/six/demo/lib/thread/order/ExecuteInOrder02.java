package ca.six.demo.lib.thread.order;

import java.util.concurrent.Semaphore;

public class ExecuteInOrder02 {
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        s1.acquire();
        s2.acquire();

        Thread t1 = new Thread(() -> {
            foo.first();
            s1.release();
        });
        Thread t2 = new Thread(() -> {
            acquireSemaphore(s1);
            foo.second();
            s2.release();
        });
        Thread t3 = new Thread(() -> {
            acquireSemaphore(s2);
            foo.third();
        });

        t3.start();
        t2.start();
        t1.start();
    }

    private static void acquireSemaphore(Semaphore s){
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}