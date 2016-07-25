package javat.thread.philosophers.good;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick2 {
    private Lock lock;

    public Chopstick2() {
        lock = new ReentrantLock();
    }

    public boolean bePickUp(){
        return lock.tryLock();
    }

    public void bePutDown(){
        lock.unlock();
    }
}