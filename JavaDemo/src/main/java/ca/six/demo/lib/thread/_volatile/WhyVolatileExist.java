package ca.six.demo.lib.thread._volatile;

// It's hard to debug because of the multi-thread
public class WhyVolatileExist {
    volatile long a = 1;
    volatile long b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print() {
        if (a == 1 && b == 3) {
            System.out.println("Thread[" + Thread.currentThread().getName() + "]Confused1 : a = 1, b = 3");
        } else if (a == 3 && b == 2) {
            System.out.println("Thread[" + Thread.currentThread().getName() + "]Confused2 : a = 3, b = 2");
        } else {
//            System.out.println("Thread[" + Thread.currentThread().getName() + "] b=" + b + ";a=" + a);
        }
    }

    public static void main(String[] args) {
        // create many many threads
        while (true) {
            // create test every time, to make sure a is 1 and b is 2 again
            final WhyVolatileExist test = new WhyVolatileExist();

            // one thread for changing
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            // one thread for printing
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }
}

