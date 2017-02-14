package ca.six.demo.lib.thread._volatile;

import java.util.concurrent.atomic.AtomicInteger;

public class WhyVolatileExist {
    volatile AtomicInteger a = new AtomicInteger(1);
    volatile AtomicInteger b = new AtomicInteger(2);

    public void change() {
        a = new AtomicInteger(3);
        b = new AtomicInteger(3);
    }

    public void print() {
        if (a.get() == 1 && b.get() == 3) {
            // why this is happening?
            System.out.println("Thread[" + Thread.currentThread().getName() + "]Confused1 : a = 1, b = 3");
        } else if (a.get() == 3 && b.get() == 2) {
            // never happened. Why?
            System.out.println("Thread[" + Thread.currentThread().getName() + "]Confused2 : a = 1, b = 3");
        } else {
//            System.out.println("Thread[" + Thread.currentThread().getName() + "] b=" + b + ";a=" + a);
        }
    }

    public static void main(String[] args) {
        // create many many threads
        while (true) {
            // create test every time, to make sure a is 1 and b is 2 again
            final WhyVolatileExist test = new WhyVolatileExist();

            // one thread for changing
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            // one thread for printing
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }
}