package ca.six.demo.collections.stack;

import java.util.ArrayDeque;
import java.util.Deque;

// java.util.Stack does not have the contains(object), remove(object) methods. So we can not use java.util.Stack directly.
// so we are going to use Deque to implement a stack without duplicated items
public class UniqueStack<E> {
    private Deque<E> deque = new ArrayDeque<>(); // LinkedList也是Deque的一个实现类

    public void push(E item) {
        boolean isContaining = deque.contains(item);
        if (isContaining) {
            deque.remove(item);
        }
        deque.addFirst(item);
    }

    public E pop() {
        return deque.getFirst();
    }

    public E peek() {
        return deque.peekFirst();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    void print() {
        for (E e : deque) { //从栈顶到栈底打印
            System.out.println("szw e = " + e);
        }
    }
}

class Demo {
    public static void main(String[] args) {
        UniqueStack<Integer> stack = new UniqueStack<>();
        stack.push(23);
        stack.push(3);
        stack.push(4);
        stack.push(23);
        stack.push(4);
        stack.push(2);

        stack.print(); //=> 从顶到底是 2, 4, 23, 3
    }
}
