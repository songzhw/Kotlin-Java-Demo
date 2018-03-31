package ca.six.demo.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

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
