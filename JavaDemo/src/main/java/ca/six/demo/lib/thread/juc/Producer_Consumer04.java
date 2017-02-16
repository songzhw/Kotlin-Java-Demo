package ca.six.demo.lib.thread.juc;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.concurrent.Semaphore;

public class Producer_Consumer04 {
    public static void main(String[] args) {
        Semaphore semaphoreProducer = new Semaphore(2); // 空位最多2个，可用来生产。 初始值为2， 即有2个空位
        // ▼, permit值从2，改成了0
        Semaphore semaphoreConsumer = new Semaphore(0); // 货物最多2个，可供消费。 初始值为0， 即没有货物

        // ▼ 因为permit初始值已经为0了， 所以不用再先行acquire()了
//        ThreadUtils.requirePermit(semaphoreConsumer);  // ▼ 注释掉
//        ThreadUtils.requirePermit(semaphoreConsumer);  // ▼ 注释掉

        Producer4 producer=new Producer4(semaphoreProducer,semaphoreConsumer);
        Consumer4 consumer=new Consumer4(semaphoreConsumer,semaphoreProducer);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}


class Producer4 implements Runnable {
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;

    public Producer4(Semaphore semaphoreProducer, Semaphore semaphoreConsumer) {
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

class Consumer4 implements Runnable {

    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;

    public Consumer4(Semaphore semaphoreConsumer, Semaphore semaphoreProducer) {
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