package ca.six.algo.stack_queue

import java.util.*

class Q2Stack<E> {
//    private val inQueue = Queue<E>() // Queue在java中是接口, 不能new
    private val inQueue = LinkedList<E>() // LinkedList是Queue接口的实现类
    private val outQueue = LinkedList<E>()

    fun push(e: E){

    }

    fun pop(){}

}

fun main() {
    val stack = Q2Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack.pop())

    stack.push(4)
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())


}