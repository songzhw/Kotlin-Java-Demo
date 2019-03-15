package thread.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CasScenario01 {
    static int indexBad = 0;
    static AtomicInteger indexGood = new AtomicInteger(0);

    public void count() {
        indexBad++;
    }

    public void safecount() {
        indexGood.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        final CasScenario01 c = new CasScenario01();
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int k = 0; k < 100; k++) {
            executorService.execute(() -> {
                for (int m = 0; m < 100; m++) {
                    c.count();
                    c.safecount();
                }
            });
        }
        Thread.sleep(8000);
        System.out.println("50 threads run add:");
        System.out.println("count:" + indexBad);
        System.out.println("safecount:" + indexGood.get());
    }
}

/* log =
50 threads run add:
    count:9778
    safecount:10000

 */