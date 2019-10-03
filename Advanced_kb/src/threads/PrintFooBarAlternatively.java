package threads;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() {
        for (int i = 0; i < n; i++) {
            System.out.println("foo");
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            System.out.println("bar");
        }
    }
}

public class PrintFooBarAlternatively {
    public static void main(String[] args) {
        int count = 3;
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
