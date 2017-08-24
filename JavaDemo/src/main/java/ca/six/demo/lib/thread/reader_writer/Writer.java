package ca.six.demo.lib.thread.reader_writer;


class Writer implements Runnable {

    @Override
    public void run() {
        Res.lock.lock();
        try {
            Res.writeSemaphore.acquire(1);     //同时只有一个写者可以进入
            System.out.println("     (write)写者正在写");
            Res.writeSemaphore.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Res.lock.unlock();
        }

    }

}