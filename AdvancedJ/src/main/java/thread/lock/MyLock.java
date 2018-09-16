package thread.lock;

class MyLock {
    private boolean isLocked = false;

    synchronized public void lock() throws InterruptedException {
        while (isLocked) {
            this.wait(); //要写在synchornized里, 不然会crash
        }
        isLocked = true;
    }

    synchronized public void unlock() throws InterruptedException {
        isLocked = false;
        this.notify(); //要写在synchornized里, 不然会crash
    }
}

