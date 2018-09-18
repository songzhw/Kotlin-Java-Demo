package thread.ti;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated  //因为这个例子完全没有达到"交替打印出奇偶数"的效果. Failed
public class PrintOddEventByOrder2 {
    private Lock lock = new ReentrantLock();

    public void start() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                lock.lock();
                System.out.println("===> " + i);
                lock.unlock();

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                lock.lock();
                System.out.println("*** " + i);
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        PrintOddEventByOrder2 obj = new PrintOddEventByOrder2();
        obj.start();
    }
}
