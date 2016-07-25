package javat.thread.Semaphore;

import javat.thread.ThreadUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by songzhw on 2016-07-25.
 * <p>
 * Semaphore可以控制某个资源可被同时访问的个数，
 * 通过 acquire() 获取一个许可，如果没有就等待，
 * 而 release() 释放一个许可。
 * <p>
 * 比如在Windows下可以设置共享文件的最大客户端访问个数。
 */
public class Foo2 {
    private Semaphore sem1, sem2, sem3;

    public Foo2() {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);

        try {
            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void first() {
        try {
            ThreadUtils.sleep(5000);
            System.out.println("first");
            sem1.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void second() {
        try {
            sem1.acquire(); // since the CF alreay holds the sem1, this has to be wait
            sem1.release();

            ThreadUtils.sleep(3000);
            System.out.println("second");

            sem2.release();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void third() {
        try {
            sem2.acquire();
            sem2.release();

            ThreadUtils.sleep(1000);
            System.out.println("third");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Foo2 foo2 = new Foo2();

        new Thread(() -> foo2.first())
                .start();

        new Thread(() -> foo2.second())
                .start();

        new Thread(() -> foo2.third())
                .start();

        BlockingQueue s;
    }

}

// output : first, second, third