package thread.ti;

import java.util.concurrent.atomic.AtomicBoolean;

// 两个线程交替打印 1 - 20
public class PrintOddEventByOrder {

    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        AtomicBoolean isOneRun = new AtomicBoolean(false);

        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("===> " + i);
                isOneRun.set(true);

                anotify(lock2);
                if (i != 9) {
                    await(lock1);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            if(!isOneRun.get()){
                await(lock2);
            }

            for (int i = 2; i <= 10; i += 2) {
                System.out.println("*** " + i);

                anotify(lock1);
                if (i != 10) {
                    await(lock2);
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void await(Object lock) {
        try {
            synchronized (lock) {
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void anotify(Object lock) {
        synchronized (lock) {
            lock.notify();
        }
    }

}
