package ca.six.demo.collections.stack;

import java.util.Stack;

// java.util.Stack is a child of Vector class. So Stack has "public int search(object)" method to return the index
public class UniqueStack2<E> extends Stack<E>{

    @Override
    public E push(E item) {
        boolean isContaining = this.contains(item);
        if (isContaining) {
            this.remove(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized E pop() {
        return super.pop();
    }

    @Override
    public synchronized E peek() {
        return super.peek();
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    void print(){
        for(E e: this){ //从栈底到栈顶打印
            System.out.println("szw2 e = "+e);
        }
    }
}

class Demo2 {
    public static void main(String[] args) {
        UniqueStack2<Integer> stack = new UniqueStack2<>();
        stack.push(23);
        stack.push(3);
        stack.push(4);
        stack.push(23);
        stack.push(4);
        stack.push(2);

        stack.print(); //=> 从顶到底是 2, 4, 23, 3
        System.out.println("szw ** "+stack.peek());
    }
}

