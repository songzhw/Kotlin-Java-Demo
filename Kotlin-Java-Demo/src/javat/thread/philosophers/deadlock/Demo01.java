package javat.thread.philosophers.deadlock;

/**
 * Created by songzhw on 2016-07-25.
 */
public class Demo01 {
    public static void main(String[] args) {
        // init
        Chopstick1[] chopsticks = new Chopstick1[10];
        for(int i = 0 ; i < 10; i++) {
            chopsticks[i] = new Chopstick1();
        }

        Philosopher1[] philosophers = new Philosopher1[10];
        for(int i = 0 ; i < 10; i++) {
            int next = (i + 1 ) % 10;
            philosophers[i] = new Philosopher1(chopsticks[i], chopsticks[next], "No. "+i);
        }

        // start to eat
        for(int i = 0 ; i < 10; i++) {
            philosophers[i].start();
        }
    }
}
