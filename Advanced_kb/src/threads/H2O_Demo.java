package threads;

/*
现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。

存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。

氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。

这些线程应该三三成组突破屏障并能立即组合产生一个水分子。

你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。

换句话说:
如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
书写满足这些限制条件的氢、氧线程同步代码。

链接：https://leetcode-cn.com/problems/building-h2o
 */

import java.util.concurrent.Semaphore;

class H2O {
    private int count;
    private Semaphore hCell = new Semaphore(2);
    private Semaphore oCell = new Semaphore(0);

    H2O(int count) {
        this.count = count;
    }

    public void hydrogen() {
        try {
                hCell.acquire(2);
                System.out.print("HH");
                oCell.release();
        } catch (InterruptedException e) {
        }

    }

    public void oxygen() {
        try {
            oCell.acquire();
            System.out.println("O,");
            hCell.release(2);
        } catch (Exception e) {
        }
    }
}


public class H2O_Demo {
    public static void main(String[] args) {
        int waterCellCount = 3;
        H2O water = new H2O(waterCellCount);

        Thread a = new Thread(() -> {
            water.hydrogen();
        });
        Thread b = new Thread(() -> {
            water.oxygen();
        });
        a.start();
        b.start();

    }
}

/*
 [重点]:
 1. Semaphore有: 	acquire(int permits)
 */