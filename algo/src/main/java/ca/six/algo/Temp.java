package ca.six.algo;

import java.util.Stack;

class Temp {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (!stack.isEmpty() && stack.peek() < 10) {
            System.out.println("right");
            stack.push(12);
        }
        System.out.println("end");
    }
}
