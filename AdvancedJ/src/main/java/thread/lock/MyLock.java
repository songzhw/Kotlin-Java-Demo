package thread.lock;

class MyLock {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    synchronized public void lock() throws InterruptedException {
        Thread current = Thread.currentThread();

        while (isLocked && lockedBy != current) {
            this.wait(); //要写在synchornized里, 不然会crash
        }
        isLocked = true;
        lockedCount++;
        lockedBy = current;
    }

    synchronized public void unlock() throws InterruptedException {
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;

            if(lockedCount == 0){
                isLocked = false; //上面是while(A & B), 用的是&, 所以这里不让lockedBy = null也是行的
                this.notify(); //要写在synchornized里, 不然会crash
            }
        }

    }
}

