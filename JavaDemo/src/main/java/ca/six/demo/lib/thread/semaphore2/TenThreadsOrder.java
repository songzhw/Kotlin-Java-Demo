package ca.six.demo.lib.thread.semaphore2;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by songzhw on 2016-08-01.
 *
 * 现成程序中的Test类中的代码在不断地产生数据，然后交给foo()方法去处理，
 * 就好像生产者在不断地产生数据，消费者在不断消费数据。
 *
 * 请将程序改造成有10个线程来消费生成者产生的数据，
 * 这些消费者都调用foo()方法去进行处理，故每个消费者都需要一秒才能处理完，
 * 程序应保证这些消费者线程依次有序地消费数据，
 * 只有上一个消费者消费完后，下一个消费者才能消费数据，
 * 下一个消费者是谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。
 *
 */
public class TenThreadsOrder {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(1, true);
        final SynchronousQueue<String> queue = new SynchronousQueue<>();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();

                        String input = queue.take();
                        String output = foo(input);
                        System.out.println(Thread.currentThread().getName() + " : " + output);

                        semaphore.release();
                    } catch (Exception e) {
                    }
                }
            }).start();
        }

        System.out.println("begin=============");
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String foo(String input) {
        ThreadUtils.sleep(1000);
        return input + " : " + (System.currentTimeMillis() / 1000);
    }
}
