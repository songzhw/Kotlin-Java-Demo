package ca.six.algo.stack_queue

import java.util.*

class S2Queue<E> {
    private val inStack = Stack<E>()
    private val outStack = Stack<E>()

    fun size() = inStack.size + outStack.size

    fun inqueue(e: E) {
        inStack.push(e)
    }

    fun dequeue(): E {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.pop()
    }

    override fun toString(): String {
        return super.toString()
    }

}


fun main() {
    val queue = S2Queue<Int>()
    queue.inqueue(1)
    queue.inqueue(2)
    queue.inqueue(3)
    println("queue1 = $queue")

    println(queue.dequeue())
    println("queue2 = $queue")

    queue.inqueue(4)
    println(queue.dequeue())
    println("queue3 = $queue")

}