package ca.six.demo.lib.thread.cons_prod;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by songzhw on 2017-01-09.
 */
public class ConsProdMain {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(3);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        System.out.println("=========== start ==========");
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
