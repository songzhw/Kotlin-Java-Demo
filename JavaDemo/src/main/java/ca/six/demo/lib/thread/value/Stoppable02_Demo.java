package ca.six.demo.lib.thread.value;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by songzhw on 2017-02-12.
 */
public class Stoppable02_Demo {
    public static void main(String[] args) {
        Stoppable02 t3 = new Stoppable02();
        Stoppable02 t4 = new Stoppable02();
        System.out.println("=====");

        t3.start(500);
        t4.start(1000);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("--- Break Line ----");
                t3.setRun(false);
            }
        }, 1300);
    }

    // t1停止后， t2也停止了。 因为isRun这次成了static了

}
