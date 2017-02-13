package ca.six.demo.lib.thread.value;

/**
 * Created by songzhw on 2017-02-12.
 */
public class Stoppable01 extends Thread {
    private boolean isRun;
    private int lap;

    public void setRun(boolean run) {
        isRun = run;
    }

    @Override
    public void run() {
        while (isRun) {
            System.out.println("Current Thread = " + Thread.currentThread().getName());

            try {
                Thread.sleep(lap);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(int lap) {
        this.lap = lap;
        this.setName("[Thread " + lap  + "] ");
        isRun = true;
        start();
    }

}
