package thread.ti;

import java.util.concurrent.Semaphore;

@Deprecated //太绕了, 没法理清思路
public class PrintOddEventByOrder_Semaphore {
    private Semaphore semaphore1, semaphore2;

    public PrintOddEventByOrder_Semaphore() throws InterruptedException {
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(1);

        semaphore1.acquire();
        semaphore2.acquire();
    }

    public void work() {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                try {
                    if (i != 1) {
                        semaphore1.acquire();
                    }
                    System.out.println("===> " + i);
                    semaphore2.release();
                    semaphore1.acquire();
                } catch (InterruptedException e) {
                }

            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                try {
                    semaphore2.acquire();
                    System.out.println("*** " + i);
                    semaphore1.release();
                    semaphore2.acquire();
                } catch (InterruptedException e) {
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        PrintOddEventByOrder_Semaphore obj = new PrintOddEventByOrder_Semaphore();
        obj.work();
    }
}
