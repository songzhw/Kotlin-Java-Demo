package javat.thread.philosophers.deadlock;

import javat.thread.ThreadUtils;

import java.util.Random;

/**
 * Created by songzhw on 2016-07-25.
 */
public class Philosopher1 extends Thread {
    private Chopstick1 left;
    private Chopstick1 right;
    private String name;

    public Philosopher1(Chopstick1 l, Chopstick1 r, String n) {
        this.left = l;
        this.right = r;
        this.name = n;
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    private void pickUp() {
        left.bePickUp();
        right.bePickUp();
    }

    private void chew() {
//        ThreadUtils.sleep((long) (1000 + Math.random() * 4000));
        ThreadUtils.sleep(1000);
        System.out.println(name + " chew");
    }

    private void putDown() {
        left.bePutDown();
        right.bePutDown();
    }

    @Override
    public void run() {
        eat();
    }
}
