package ca.six.demo.lib.thread.philosopher;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.Random;

public class Philosopher extends Thread {
    private String name;
    private Chopstick left, right;
    private Random random;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.name = name;
        this.left = left;
        this.right = right;
        random = new Random();
    }

    public void run() {
        while (true) {
            ThreadUtils.sleep(random.nextInt(1000));        //思考一段时间
            synchronized (left) {                       //拿起左手边筷子
                System.out.println("szw p[" + name + "] got left");
                ThreadUtils.sleep(1000);
                synchronized (right) {                  //拿起右手边筷子
                    System.out.println("szw p[" + name + "] got right");
                    ThreadUtils.sleep(random.nextInt(1000));//进餐一段时间
                }
            }
        }
    }
}
