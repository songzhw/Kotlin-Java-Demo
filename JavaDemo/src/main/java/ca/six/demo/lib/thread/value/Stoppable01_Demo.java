package ca.six.demo.lib.thread.value;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by songzhw on 2017-02-12.
 */
public class Stoppable01_Demo {
    public static void main(String[] args) {
        Stoppable01 t1 = new Stoppable01();
        Stoppable01 t2 = new Stoppable01();
        System.out.println("=====");

        t1.start(500);
        t2.start(1000);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- Break Line ----");
                t1.setRun(false);
            }
        }, 1300);
    }

    // t1停止后， t2仍在不断地运行.
    // 所以Stoppable01中的 isRun， 这个肯定是随对象的
}
