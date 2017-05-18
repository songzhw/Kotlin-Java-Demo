package ca.six.demo.lib.thread.queue1;

import ca.six.demo.lib.thread.ThreadUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by songzhw on 2016-07-29.
 * <p>
 * 思路： BlockingQueue。  由BlockingQueue来存这16个数据，
 * thread可以自己去queue里取数据，
 * 做完一个， 就通过while循环，自动再去queue中取下一个数据来处理就好了。
 */
public class Queue1Demo {
    public static void parseLog(String log) {
        System.out.println("log[" + log + "] = " + System.currentTimeMillis() / 1000);
        ThreadUtils.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(16);

        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                int index = 0;
                @Override
                public void run() {
                    while(index < 4) {
                        try {
                            String log = queue.take();
                            parseLog(log);
                            index++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            ).start();
        }

        for (int i = 1; i <= 16; i++) {
            String log = "" + i;
            queue.put(log);
        }
    }
}
