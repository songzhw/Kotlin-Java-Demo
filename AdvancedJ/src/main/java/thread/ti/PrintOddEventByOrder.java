package thread.ti;

// 两个线程交替打印 1 - 20
public class PrintOddEventByOrder {

    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 20; i += 2) {
                System.out.println("===> " + i);

                anotify(lock2);
                if (i != 19) {
                    await(lock1);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 20; i += 2) {
                System.out.println("*** " + i);

                anotify(lock1);
                if (i != 20) {
                    await(lock2);
                }
            }
        });

        await(lock2);
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
