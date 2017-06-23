package ca.six.klplay.advanced.function


import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

// body()方法就一定得是无参方法， 即返回值为T
fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()

    try {
        return body()
    } finally {
        lock.unlock()
    }
}

//fun getName(String s) : String { //=> 套不进lock()的第二参的
fun getName(): String {
    return "songzhw"
}

fun main(args: Array<String>) {
    val ret = lock(ReentrantLock(), ::getName)
    println("result = $ret")
}


