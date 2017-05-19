package ca.six.demo.lib.thread.philosophers.good;

import javat.thread.ThreadUtils;

import java.util.Random;

/**
 * Created by songzhw on 2016-07-25.
 */
public class Philosopher2 extends Thread {
    private Chopstick2 left;
    private Chopstick2 right;
    private String name;

    public Philosopher2(Chopstick2 l, Chopstick2 r, String n) {
        this.left = l;
        this.right = r;
        this.name = n;
    }

    public void eat() {
        if(pickUp()) {
            chew();
            putDown();
        }
    }

    private boolean pickUp() {
        if(!left.bePickUp()){
            return false;
        }
        if(!right.bePickUp()){
            left.bePutDown();
            return false;
        }
        return true;
    }

    private void chew() {
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
