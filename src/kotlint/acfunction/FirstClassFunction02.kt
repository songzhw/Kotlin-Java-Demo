package cn.song.acfunction
/**
 * Created by hzsongzhengwang on 2015/8/17.
 */

import java.util.concurrent.locks.Lock

fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    }
    finally {
        lock.unlock()
    }
}

// how to use it  : "::" or lambda
//fun toBeSynchronized() = sharedResource.operation()
//val result = lock(lock, ::toBeSynchronized)
//
//val result = lock(lock, { sharedResource.operation() })