package ca.six.demo.lib.thread.others;

import java.util.function.Function;
import java.util.function.Predicate;

public class FiBuzzThread extends Thread {
    private static Object lock = new Object();
    protected  static int current = 1; //注意是static
    private int max;
    private Predicate<Integer> validater;
    private Function<Integer, String> printer;
    int x = 1;

    public FiBuzzThread(Predicate<Integer> validate, Function<Integer, String> printer, int max){
        this.validater = validate;
        this.printer = printer;
        this.max = max;
    }

    @Override
    public void run() {
        while (true){
            synchronized(lock){
                if(current > max) {
                    return;
                }
                if(validater.test(current)) {
                    System.out.println(printer.apply(current));
                    current++;
                }
            }
        }
    }
}
