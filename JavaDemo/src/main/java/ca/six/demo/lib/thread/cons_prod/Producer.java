package ca.six.demo.lib.thread.cons_prod;

import java.util.concurrent.BlockingQueue;

/**
 * Created by songzhw on 2017-01-09.
 */
public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            Message msg = new Message("" + i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produce (" + i + ") ： "+System.currentTimeMillis());
                System.out.println("after produce : size = "+queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            Message exitMsg = new Message("exit");
            queue.put(exitMsg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
