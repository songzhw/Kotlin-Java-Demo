package ca.six.demo.lib.thread.cons_prod;

import java.util.concurrent.BlockingQueue;

/**
 * Created by songzhw on 2017-01-09.
 */
public class Consumer implements Runnable{

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Message msg;
            //获取并处理消息直到接收到“exit”消息
            while(!(msg = queue.take()).msg.equals("exit")){
                Thread.sleep(10);
                System.out.println("Consumed "+msg.msg +"————————"+System.currentTimeMillis());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
