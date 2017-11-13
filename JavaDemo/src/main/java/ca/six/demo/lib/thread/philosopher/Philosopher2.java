package ca.six.demo.lib.thread.philosopher;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.Random;

public class Philosopher2 extends Thread {
    private String name;
    private final Chopstick big, small;
    private Random random;

    public Philosopher2(String name, Chopstick left, Chopstick right) {
        this.name = name;
        big = left.id > right.id ? left : right;
        small = left.id > right.id ? right : left;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            ThreadUtils.sleep(random.nextInt(1000));
            //1会拿1号, 2会拿2号, ...5会拿5号, 6手上有0和5号, 这时他应该拿5. 但5被拿了, 所以就等. 所以1号能拿到0和1号. 这样就不会死锁了
            synchronized (big) {
                System.out.println("szw p[" + name + "] got left");
                ThreadUtils.sleep(1000);
                synchronized (small) {
                    System.out.println("szw p[" + name + "] got right");
                    ThreadUtils.sleep(random.nextInt(1000));
                }
            }
        }
    }
}
