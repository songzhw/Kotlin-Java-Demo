package thread.barrier;

import java.util.concurrent.CyclicBarrier;

public class GameDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        Thread p1 = new Thread(new Player("player01", barrier));
        Thread p2 = new Thread(new Player("player02", barrier));
        Thread p3 = new Thread(new Player("player03", barrier));

        p1.start();
        p2.start();
        p3.start();
    }
}
