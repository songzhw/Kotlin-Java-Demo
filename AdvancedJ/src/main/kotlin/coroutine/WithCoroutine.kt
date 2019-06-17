package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun getId2(): Int {
    println("getID2: ${Thread.currentThread().name}")
    Thread.sleep(500)
    return 23
}

fun getUser2(id: Int): String {
    println("getUser2: ${Thread.currentThread().name}")
    Thread.sleep(900)
    return "getUser($id)"
}

fun getInfo2(user: String): String {
    println("getInfo2: ${Thread.currentThread().name}")
    Thread.sleep(600)
    return "getInfo($user)"
}

fun main() = runBlocking {
    GlobalScope.launch {
        val id = getId2()
        val user = getUser2(id)
        val info = getInfo2(user)
        println("sze result = $info || ${Thread.currentThread().name}")
    }
    println("before delay")
    delay(5000)  //等待所有工作做完, 再让JVM结果 (keep JVM alive for 5 seconds)
    println("after delay")
}

/*
getID2: DefaultDispatcher-worker-1
getUser2: DefaultDispatcher-worker-1
getInfo2: DefaultDispatcher-worker-1
sze result = getInfo(getUser(23)) || DefaultDispatcher-worker-1
 */