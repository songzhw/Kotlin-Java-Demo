package ca.six.demo.lib.thread.philosopher;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[6];
        for (int i = 0; i < 6; i++) {
            chopsticks[i] = new Chopstick();
        }

        Philosopher p1 = new Philosopher("1",chopsticks[0], chopsticks[1]);
        Philosopher p2 = new Philosopher("2",chopsticks[1], chopsticks[2]);
        Philosopher p3 = new Philosopher("3",chopsticks[2], chopsticks[3]);
        Philosopher p4 = new Philosopher("4",chopsticks[3], chopsticks[4]);
        Philosopher p5 = new Philosopher("5",chopsticks[4], chopsticks[5]);
        Philosopher p6 = new Philosopher("6",chopsticks[5], chopsticks[0]);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
    }

}