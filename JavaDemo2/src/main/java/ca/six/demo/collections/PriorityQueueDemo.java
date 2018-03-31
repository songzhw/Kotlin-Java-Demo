package ca.six.demo.collections;

import java.util.PriorityQueue;

// TODO thread-safe的还有PriroityBlockingQueue类可用

/*
注意1：该队列是用数组实现，但是数组大小可以动态增加，容量无限。

注意2：队列的实现不是同步的。不是线程安全的。如果多个线程中的任意线程从结构上修改了列表， 则这些线程不应同时访问 PriorityQueue实例。保证线程安全可以使用PriorityBlockingQueue 类。

注意3：不允许使用 null 元素。

注意4：插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n)) ；
remove(Object) 和 contains(Object) 时间复杂度为O(n)；
检索方法（peek、element 和 size）时间复杂度为常量。

注意5：方法iterator()中提供的迭代器并不保证以有序的方式遍历优先级队列中的元素。（原因可参考PriorityQueue的内部实现）
如果需要按顺序遍历，可用Arrays.sort(pq.toArray())。

注意6：可以在构造函数中指定如何排序。如：
PriorityQueue()
          使用默认的初始容量（11）创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
PriorityQueue(int initialCapacity)
          使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序来排序其元素（使用 Comparable）。
PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
          使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器comparator来排序其元素。

注意7：此类及其迭代器实现了 Collection 和 Iterator 接口的所有可选 方法。

PriorityQueue对元素采用的是堆排序，头是按指定排序方式的最小元素。堆排序只能保证根是最大（最小），整个堆并不是有序的。
方法iterator()中提供的迭代器可能只是对整个数组的依次遍历。也就只能保证数组的第一个元素是最小的。

 */

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueueDemo obj = new PriorityQueueDemo();
        obj.foo();
    }

    void foo() {
        Request req1 = new Request(1);
        Request req4 = new Request(4);
        Request req6 = new Request(6);
        Request req3 = new Request(3);

        PriorityQueue<Request> queue = new PriorityQueue<>(11, (req11, req22) -> req11.priority - req22.priority);
        queue.add(req3);
        System.out.println("szw peek3 : "+queue.peek());
        queue.add(req4);
        System.out.println("szw peek4 : "+queue.peek());
        queue.add(req1);
        System.out.println("szw peek1 : "+queue.peek());
        queue.add(req6);
        System.out.println("szw peek6 : "+queue.peek());


    }


}

/*
    szw peek3 : Request{priority=3}
    szw peek4 : Request{priority=3}
    szw peek1 : Request{priority=1}
    szw peek6 : Request{priority=1}
 */
