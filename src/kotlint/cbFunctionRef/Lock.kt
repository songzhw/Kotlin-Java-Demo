package cn.song.cbFunctionRef

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */

//1. two operations
// =================== () -> ===================
// ===================  ::   ===================



//2. demo
fun lock00<T>(lock : Lock, body: ()-> T) : T {
    lock.lock()
    try{
        return body()
    } finally{
        lock.unlock()
    }
}

fun foo00() = 3  // means :  fun foo() { return 3 }

fun main(args: Array<String>) {
    // the first param is "new ReentrantLock()"
    // the second param is a function type
    lock00(ReentrantLock(), ::foo00) //how to pass a function as a parameter of another function? : use "::" operation
}
