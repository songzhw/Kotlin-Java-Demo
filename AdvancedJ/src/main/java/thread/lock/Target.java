package thread.lock;

public class Target {
    synchronized public void outer() {
        inner();
    }

    synchronized public void inner() {
    }
}

class Target2{
    MyLock lock = new MyLock();

    public void outer() throws InterruptedException {
        lock.lock();
        inner();
        lock.unlock();
    }

    public void inner() throws InterruptedException {
        lock.lock();
        // do something
        lock.unlock();
    }
}
