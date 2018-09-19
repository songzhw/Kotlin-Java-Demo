package thread.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player implements Runnable {
    private final String player;
    private final CyclicBarrier barrier;

    public Player(String player, CyclicBarrier barrier) {
        this.player = player;
        this.barrier = barrier;
    }


    @Override
    public void run() {
        try {
            System.out.println(player + "find other players");
            findOtherPlayers();
            barrier.await();

            System.out.println(player + "select a hero");
            selectHero();
            barrier.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void selectHero() {
        sleep(500);
    }


    private void findOtherPlayers() {
        sleep(2000);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
