class Th {
    final Object lock = new Object();

    public void watch() throws InterruptedException {
        System.out.println("I wait()");
        synchronized (lock) {
            lock.wait();
        }
    }

    public void onWatchOver() {
        // release the lock
        synchronized (lock) {
            lock.notify();
        }
    }
}
