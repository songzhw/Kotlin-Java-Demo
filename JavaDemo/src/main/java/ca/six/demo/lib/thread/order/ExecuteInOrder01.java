package ca.six.demo.lib.thread.order;

public class ExecuteInOrder01 {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.first();
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.second();
            }
        }) ;
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                foo.third();
            }
        }) ;

        t3.start();
        t2.start();
        t1.start();
    }
}
//=> third(), second(), first()
