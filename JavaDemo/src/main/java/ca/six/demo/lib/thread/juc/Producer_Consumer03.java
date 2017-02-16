package ca.six.demo.lib.thread.juc;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.concurrent.Semaphore;

public class Producer_Consumer03 {
    public static void main(String[] args) {
        Semaphore semaphoreProducer = new Semaphore(2); // 空位最多2个，可用来生产
        Semaphore semaphoreConsumer = new Semaphore(2); // 货物最多2个，可供消费

        ThreadUtils.requirePermit(semaphoreConsumer);
        ThreadUtils.requirePermit(semaphoreConsumer);

        Producer3 producer=new Producer3(semaphoreProducer,semaphoreConsumer);
        Consumer3 consumer=new Consumer3(semaphoreConsumer,semaphoreProducer);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}


class Producer3 implements Runnable {
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;

    public Producer3(Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
        this.semaphoreProducer = semaphoreProducer;
        this.semaphoreConsumer = semaphoreConsumer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            ThreadUtils.sleep(500);
            ThreadUtils.requirePermit(semaphoreProducer);
            System.out.println("produced "+i);
            semaphoreConsumer.release();
        }
    }
}

class Consumer3 implements Runnable {

    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;

    public Consumer3(Semaphore semaphoreConsumer, Semaphore semaphoreProducer) {
        this.semaphoreConsumer = semaphoreConsumer;
        this.semaphoreProducer = semaphoreProducer;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            ThreadUtils.sleep(2200);
            ThreadUtils.requirePermit(semaphoreConsumer);
            System.out.println("consumed "+i);
            ThreadUtils.releasePermit(semaphoreProducer);
        }
    }
}
/*
produced 0
produced 1
consumed 0
produced 2
consumed 1
consumed 2
 */