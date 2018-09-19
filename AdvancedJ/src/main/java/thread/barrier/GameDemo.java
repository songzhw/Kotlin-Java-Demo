package thread.barrier;

import java.util.concurrent.CyclicBarrier;

public class GameDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("action in CyclicBarrier - "+Thread.currentThread().getName());
        });

        Thread p1 = new Thread(new Player("player01", barrier),"t1");
        Thread p2 = new Thread(new Player("player02", barrier),"t2");
        Thread p3 = new Thread(new Player("player03", barrier),"t3");

        p1.start();
        p2.start();
        p3.start();
    }
}
