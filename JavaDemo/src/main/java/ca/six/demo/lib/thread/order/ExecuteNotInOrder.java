package ca.six.demo.lib.thread.order;

public class ExecuteNotInOrder {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(foo::first);
        Thread t2 = new Thread(foo::second);
        Thread t3 = new Thread(foo::third); // == new Thread(() -> foo.third() );

        t3.start();
        t2.start();
        t1.start();
    }
}
//=> 顺序是不定的. 比如说可能是是这个顺序: third(), second(), first()
