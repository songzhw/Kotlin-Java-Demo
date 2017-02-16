package ca.six.demo.lib.thread.juc;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    Semaphore binary = new Semaphore(1);

    public static void main(String args[]) {
        final SemaphoreTest test = new SemaphoreTest();
        // 起两个线程
        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.mutualExclusion();
            }
        }.start();

    }

    private void mutualExclusion() {
        try {
            System.out.println("I'm waiting ("+Thread.currentThread().getName()+")");
            binary.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            binary.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    }

}

/*
Output:
    I'm waiting (Thread-0)
    Thread-0 inside mutual exclusive region
    I'm waiting (Thread-1)
    Thread-0 outside of mutual exclusive region
    Thread-1 inside mutual exclusive region
    Thread-1 outside of mutual exclusive region
*/