package javat.thread.philosophers.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by songzhw on 2016-07-25.
 */
public class Chopstick1 {
    private Lock lock;

    public Chopstick1() {
        lock = new ReentrantLock();
    }

    public void bePickUp(){
        lock.lock();
    }

    public void bePutDown(){
        lock.unlock();
    }
}
