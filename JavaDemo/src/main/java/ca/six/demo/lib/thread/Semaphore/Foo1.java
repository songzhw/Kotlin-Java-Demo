package ca.six.demo.lib.thread.Semaphore;

import ca.six.demo.lib.thread.ThreadUtils;

/**
 * Created by songzhw on 2016-07-25.
 *
 */
public class Foo1 {
    public Foo1() {
    }

    public void first(){
        ThreadUtils.sleep(5000);
        System.out.println("first");
    }

    public void second(){
        ThreadUtils.sleep(3000);
        System.out.println("second");
    }

    public void third(){
        ThreadUtils.sleep(1000);
        System.out.println("third");
    }

    public static void main(String[] args) {
        Foo1 foo1 = new Foo1();


        new Thread(() -> foo1.first()).start();

        new Thread(() -> foo1.second()).start();

        new Thread(() -> foo1.third()).start();
    }

}

// output : third, second, first