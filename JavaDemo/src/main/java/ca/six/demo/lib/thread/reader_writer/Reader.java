package ca.six.demo.lib.thread.reader_writer;

class Reader implements Runnable {
    @Override
    public void run() {
        before();             //读操作之前的操作
        read();               //读操作
        after();             //读操作之后的操作
    }

    public void before() {    //读操作之前的操作
        Res.lock.lock();
        try {
            if (Res.readCount == 0) {   //当有读者时，写者不能进入
                Res.writeSemaphore.acquire(1);
            }
            Res.readCount += 1;
            System.out.println("before: 有1位读者进入");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Res.lock.unlock();
        }
    }

    public void read() {         //读操作
        System.out.println("read: 当前有 " + Res.readCount + " 位读者");
    }

    public void after() {        //读操作之后的操作
        Res.lock.lock();
        try {
            Res.readCount -= 1;
            System.out.println("after: 有1位读者离开");
            if (Res.readCount == 0)     //当读者为0时，写者才可以进入
                Res.writeSemaphore.release(1);

        } finally {
            Res.lock.unlock();
        }
    }

}