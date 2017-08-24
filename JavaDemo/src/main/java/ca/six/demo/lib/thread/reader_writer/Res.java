package ca.six.demo.lib.thread.reader_writer;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Res {

    public static ReentrantLock lock = new ReentrantLock();   //定义锁
    public static int readCount = 0;    //读者的数量
    public static Semaphore writeSemaphore = new Semaphore(1);   //写信号量

}
