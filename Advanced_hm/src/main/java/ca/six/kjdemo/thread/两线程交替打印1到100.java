package ca.six.kjdemo.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.function.Predicate;

public class 两线程交替打印1到100 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        Print012Thread r1 = new Print012Thread(1, barrier, num -> num % 2 == 0);
        Print012Thread r2 = new Print012Thread(2, barrier, num -> num % 2 == 1);
        new Thread(r1).start();
        new Thread(r2).start();

        for (int i = 0; i < 50; i++) {
            NumberProvider.num = i;
        }
    }
}

class Print012Thread implements Runnable {
    private int id;
    private final CyclicBarrier barrier;
    private Predicate<Integer> p;

    public Print012Thread(int id, CyclicBarrier barrier, Predicate<Integer> p) {
        this.id = id;
        this.barrier = barrier;
        this.p = p;
    }

    @Override
    public void run() {
        while( NumberProvider.num < 100){
            boolean isMeet = this.p.test(NumberProvider.num);
            if(isMeet){
                print();
            }
        }
    }

    public void print(){
        try {
            System.out.println("线程(" + id + ") " + NumberProvider.num);
            barrier.await();
        } catch (Exception e) {
        }
    }
}

class NumberProvider {
    static int num = 0;
}