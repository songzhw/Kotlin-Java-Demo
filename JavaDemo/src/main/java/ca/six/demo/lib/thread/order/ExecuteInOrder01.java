package ca.six.demo.lib.thread.order;

import ca.six.demo.lib.thread.ThreadUtils;

public class ExecuteInOrder01 {
    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> foo.first());
        Thread t2 = new Thread(() -> {
            ThreadUtils.join(t1);
            foo.second();
        });
        Thread t3 = new Thread(() -> {
            ThreadUtils.join(t2); // 等同于t2.join(), 只是少了try-catch
            foo.third();
        });

        t3.start();
        t2.start();
        t1.start();
    }
}

// 1. 先要执行t2.join(), 再执行foo.third(). 这样才会有等t2的效果
// 2. t2.join(), 是说本线程(t3)要等待t2完成了, 才做.