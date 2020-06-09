package ca.six.algo.stack_queue

import java.util.*

class S2Queue<E> {
    private val inStack = Stack<E>()
    private val outStack = Stack<E>()

    fun size() = inStack.size + outStack.size

    fun inqueue(e: E) {
        inStack.push(e)
    }

    fun dequeue(): E? {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop())
            }
        }
        if(outStack.empty()){ return null}
        return outStack.pop()
    }

}


fun main() {
    val queue = S2Queue<Int>()

    // 测试边界情况: 当没元素了时
    println(queue.dequeue())


    queue.inqueue(1)
    queue.inqueue(2)
    queue.inqueue(3)

    println(queue.dequeue())

    queue.inqueue(4)
    println(queue.dequeue())

    println(queue.dequeue())
    println(queue.dequeue())

    // 测试边界情况: 当没元素了时
    println(queue.dequeue())


}