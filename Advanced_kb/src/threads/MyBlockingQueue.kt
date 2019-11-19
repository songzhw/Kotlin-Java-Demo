package threads

import kotlin.concurrent.thread

/**
 * [要求]
 * CF: MyBlockingQueue(int capacity). capacity是队列的长度的上限
 * void enqueue(int item) : 队首增加item. 如果队列满, 调用线程被阻塞直在到队列非满
 * int dequeue(): 返回队尾item. 若队列为空, 调用线程被阻塞直到队列非空
 * int size(): 返回队列长度
 *
 * 实现要求有多个线程同时访问. 每一个线程要么是只调用enqueue的生产者线程,
 * 要么是只调用dequeue的消费者线程.
 */

class MyBlockingQueue(val capacity: Int) {
    fun enqueue(item: Int) {}
    fun dequeue(): Int {
        return 0
    }

}

fun main() {
    val queue = MyBlockingQueue(3)
    for (i in 0..5) {
        thread {
            println("szw thread = ${Thread.currentThread().name}")
            queue.enqueue(i)
        }
    }
}