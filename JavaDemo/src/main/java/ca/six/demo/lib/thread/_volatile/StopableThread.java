package ca.six.demo.lib.thread._volatile;

/**
 * Created by songzhw on 2017-02-13.
 */
public class StopableThread extends Thread {
    private volatile boolean isRun;

    public void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public void run() {
        while (isRun) {
            // do something
        }
    }
}
