package thread.ti;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated //太绕了, 没法理清思路
public class PrintOddEventByOrder_Condition {
    private Lock lock = new ReentrantLock();
    private Condition isOnesTurn = lock.newCondition();
    private Condition isTwosTurn = lock.newCondition();


    public void work() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                lock.lock();
                try {
                    System.out.println("===> " + i);
                    isTwosTurn.signal();
                    isOnesTurn.await();
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                lock.lock();
                try {
                    System.out.println("*** " + i);
                    isOnesTurn.signal();
                    isTwosTurn.await();
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintOddEventByOrder_Condition obj = new PrintOddEventByOrder_Condition();
        obj.work();
    }
}
