package threads;

import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore seFoo = new Semaphore(1);
    private Semaphore seBar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() {
        try {
            for (int i = 0; i < n; i++) {
                seFoo.acquire();
                System.out.print("foo");
                seBar.release();
            }
        } catch (Exception e) {
        }
    }

    public void bar() {
        try {
            for (int i = 0; i < n; i++) {
                seBar.acquire();
                System.out.println("bar");
                seFoo.release();
            }
        } catch (Exception e) {
        }
    }
}

public class PrintFooBarAlternatively {
    public static void main(String[] args) {
        int count = 6;
        FooBar target = new FooBar(count);

        Thread a = new Thread(() -> {
            target.foo();
        });

        Thread b = new Thread(() -> {
            target.bar();
        });

        b.start();
        a.start();
    }
}
