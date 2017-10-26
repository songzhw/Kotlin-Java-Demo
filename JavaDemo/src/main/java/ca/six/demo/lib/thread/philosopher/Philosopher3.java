package ca.six.demo.lib.thread.philosopher;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher3 extends Thread{
    private ReentrantLock fork, knife;
    private String name;
    private Random random = new Random();

    public Philosopher3(String name, ReentrantLock fork, ReentrantLock knife) {
        this.name = name;
        this.fork = fork;
        this.knife = knife;
    }

    @Override
    public void run() {
        while (true) {
            think();
            fork.lock();
            System.out.println("szw p["+name+"] get left");
            try {
                if (knife.tryLock(300, TimeUnit.MILLISECONDS)) {
                    System.out.println("szw p["+name+"] get right");
                    try {
                        think();
                    } finally {
                        knife.unlock();
                    }
                } else { /*do nothing, just wait the finally to unlock the fork*/}
            } catch(Exception e2){
            } finally {
                fork.unlock();
            }
        }
    }

    private void think(){
        ThreadUtils.sleep(random.nextInt(1000));
    }
}
