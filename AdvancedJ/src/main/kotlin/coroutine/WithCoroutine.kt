package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

suspend fun main() {
    GlobalScope.launch {
        val id = getId2()
        val user = getUser2(id)
        val info = getInfo2(user)
        println("sze result = $info || ${Thread.currentThread().name}")
    }
        .join() //加上join()与suspend, 不然JVM下刚运行就结束了
}

/*
getID2: DefaultDispatcher-worker-1
getUser2: DefaultDispatcher-worker-1
getInfo2: DefaultDispatcher-worker-1
sze result = getInfo(getUser(23)) || DefaultDispatcher-worker-1
 */