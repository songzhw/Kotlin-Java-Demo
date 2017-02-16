package ca.six.demo.lib.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by songzhw on 2017-01-09.
 */
public class ThreadUtils {
    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void join(Thread t) {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void requirePermit(Semaphore s){
        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void releasePermit(Semaphore s){
        s.release();
    }
}