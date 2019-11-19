package threads

import java.util.*
import java.util.concurrent.locks.ReentrantLock
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
    var queue = LinkedList<Int>()
    val lock = ReentrantLock()
    val emptyCondition = lock.newCondition()
    val fullCondition = lock.newCondition()
    var size = 0

    fun size(): Int {
        return size
    }

    fun enqueue(item: Int) {
        lock.lock()
        try {
            while (size >= capacity) {
                fullCondition.await()
            }
            queue.offerFirst(item)
            size += 1
            emptyCondition.signalAll()
        } finally {
            lock.unlock()
        }
    }


    fun dequeue(): Int {
        lock.lock()
        var ret = Int.MIN_VALUE
        try {
            while (size <= 0) {
                emptyCondition.await()
            }
            ret = queue.pollLast()
            size -= 1
            fullCondition.signalAll()
        } finally {
            lock.unlock()
        }
        return ret
    }

}

fun main() {
    val queue = MyBlockingQueue(3)
    for (i in 0..5) {
        thread {
            println("szw before = ${Thread.currentThread().name}")
            queue.enqueue(i)
            println("szw after  = ${Thread.currentThread().name}")
        }
    }
}