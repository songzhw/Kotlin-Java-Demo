package ca.six.demo.lib.thread.basic;

import ca.six.demo.lib.thread.ThreadUtils;

/**
 * Created by songz2 on 2/15/2017.
 */
public class OrderExecuteDemo {
    public static void main(String[] args) {
        OrderExecuteDemo demo = new OrderExecuteDemo();
        demo.run();
    }

    public void run(){
        System.out.println("szw start "+ System.currentTimeMillis());
        t1.start();
        t2.start();
        t3.start();
    }

    private Thread t1 = new Thread() {
        @Override
        public void run() {
            ThreadUtils.sleep(2000);
            System.out.println("szw r1 finished "+ System.currentTimeMillis());
        }
    };

    private Thread t2 = new Thread() {
        @Override
        public void run() {
            ThreadUtils.sleep(500);
            System.out.println("szw r2 finished "+ System.currentTimeMillis());
        }
    };

    private Thread t3 = new Thread() {
        @Override
        public void run() {
            ThreadUtils.sleep(1200);
            System.out.println("szw r3 finished "+ System.currentTimeMillis());
        }
    };
}