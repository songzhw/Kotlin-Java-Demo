package ca.six.demo.lib.thread.reader_writer.rw2;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriter2 {

    public static void main(String[] args) {
        final ReentrantReadWriteLock.ReadLock readLock;
        final ReentrantReadWriteLock.WriteLock writeLock;
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
        readLock = lock.readLock();
        writeLock = lock.writeLock();

        Runnable writer = new Runnable() {
            @Override
            public void run() {
                System.out.println("writer: start" + getClass());
                writeLock.lock();
                ThreadUtils.sleep(1000);
                writeLock.unlock();
                System.out.println("writer: after writeLock.lock()" + getClass());
            }
        };

        Runnable reader = new Runnable() {
            @Override
            public void run() {
                System.out.println("reader: start" + getClass());
                readLock.lock();
                ThreadUtils.sleep(2500);
                readLock.unlock();
                System.out.println("reader: after readLock.lock()" + getClass());
            }
        };

        Executor executors = Executors.newFixedThreadPool(4);
        executors.execute(new Thread(reader));
        executors.execute(new Thread(reader));
        executors.execute(new Thread(writer));
        executors.execute(new Thread(reader));
    }
}
