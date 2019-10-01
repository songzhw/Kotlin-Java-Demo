package threads;
/*
三个不同的线程将会共用一个 Foo 实例。

线程 A 将会调用 one() 方法
线程 B 将会调用 two() 方法
线程 C 将会调用 three() 方法
请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。


示例 2:
输入: [1,3,2]
输出: "onetwothree"
解释:
输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
正确的输出是 "onetwothree"。

链接：https://leetcode-cn.com/problems/print-in-order
 */


import java.util.concurrent.CountDownLatch;

class Foo {
    private CountDownLatch latch12 = new CountDownLatch(1);
    private CountDownLatch latch23 = new CountDownLatch(1);

    void one() {
        System.out.println("one");
        latch12.countDown();
    }

    void two() {
        try {
            latch12.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("two");
        latch23.countDown();
    }

    void three() {
        try {
            latch23.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("three");
    }
}

public class PrintInOrder {
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        Thread a = new Thread(foo::one);
        Thread b = new Thread(foo::two);
        Thread c = new Thread(foo::three);

        c.start();
        b.start();
        a.start();
    } // 一般情况下, 因为多线程所以不保证输出一定按start()的线程的顺序, 即上面代码不一定是: "threetwoone"
}