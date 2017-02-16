package ca.six.demo.lib.thread.juc;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.concurrent.Semaphore;

/**
 * Created by songzhw on 2017-02-15.
 */
public class Producer_Consumer02 {
    public static void main(String[] args) {
        Semaphore semaphoreProducer = new Semaphore(1);
        Semaphore semaphoreConsumer = new Semaphore(0);

        Producer2 producer=new Producer2(semaphoreProducer,semaphoreConsumer);
        Consumer2 consumer=new Consumer2(semaphoreConsumer,semaphoreProducer);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}


class Producer2 implements Runnable {
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;

    public Producer2(Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
        this.semaphoreProducer = semaphoreProducer;
        this.semaphoreConsumer = semaphoreConsumer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            ThreadUtils.requirePermit(semaphoreProducer);
            System.out.println("produced "+i);
            semaphoreConsumer.release();
        }
    }
}

class Consumer2 implements Runnable {

    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;

    public Consumer2(Semaphore semaphoreConsumer, Semaphore semaphoreProducer) {
        this.semaphoreConsumer = semaphoreConsumer;
        this.semaphoreProducer = semaphoreProducer;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            ThreadUtils.requirePermit(semaphoreConsumer);
            System.out.println("consumed "+i);
            ThreadUtils.releasePermit(semaphoreProducer);
        }
    }
}