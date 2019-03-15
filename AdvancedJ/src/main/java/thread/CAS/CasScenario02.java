package thread.CAS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CasScenario02 {
    static volatile int indexBad = 0;

    public void count() {
        indexBad++;
    }

    public static void main(String[] args) throws InterruptedException {
        final CasScenario02 c = new CasScenario02();
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int k = 0; k < 100; k++) {
            executorService.execute(() -> {
                for (int m = 0; m < 100; m++) {
                    c.count();
                }
            });
        }
        Thread.sleep(8000);
        System.out.println("10000 threads run add:");
        System.out.println("count:" + indexBad);  //=> count: 9851
    }
}