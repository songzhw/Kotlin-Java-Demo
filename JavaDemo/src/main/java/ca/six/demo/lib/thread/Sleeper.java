package ca.six.demo.lib.thread;

/**
 * Created by songzhw on 2017-01-09.
 */
public class Sleeper {

    public static void sleep(long millisSeconds){
        try {
            Thread.sleep(millisSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
