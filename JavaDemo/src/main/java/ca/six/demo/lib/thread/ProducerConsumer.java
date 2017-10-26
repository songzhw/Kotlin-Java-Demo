package ca.six.demo.lib.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private static final int MAX_CAPACITY = 10;
    private static BlockingQueue<Object> goods = new ArrayBlockingQueue<Object>(MAX_CAPACITY);

    public static void main(String[] args) {
        (new ProducerThread()).start();
        (new ConsumerThread()).start();
    }

    static class ProducerThread extends Thread {
        public void run() {
            while (true) {
                // 每隔 1000 毫秒生产一个商品
                try {
                    Thread.sleep(1000);

                    goods.put(new Object()); // 会一直堵塞
                    System.out.println("Produce goods, total: " + goods.size());
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class ConsumerThread extends Thread {
        public void run() {
            while (true) {
                // 每隔 500 毫秒消费一个商品
                try {
                    Thread.sleep(500);

                    goods.take();  // 会一直堵塞
                    System.out.println("Consume goods, total: " + goods.size());
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
