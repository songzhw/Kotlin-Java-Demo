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
import java.util.concurrent.Semaphore;

class Foo2 {
    private Semaphore s12 = new Semaphore(1);
    private Semaphore s23 = new Semaphore(0);

    void one() {
        System.out.println("A: " + s12.availablePermits());
        s12.release();
        System.out.println("" + s12.availablePermits());
    }

    void two() {
        try {
            s12.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("B");
        s23.release();
    }

    void three() {
        try {
            s23.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C");
    }
}

public class PrintInOrder2 {
    public static void main(String[] args) throws Exception {
        Foo2 foo = new Foo2();
        Thread a = new Thread(foo::one);
        Thread b = new Thread(foo::two);
        Thread c = new Thread(foo::three);

        c.start();
        b.start();
        a.start();
    } // 一般情况下, 因为多线程所以不保证输出一定按start()的线程的顺序, 即上面代码不一定是: "threetwoone"
}