package coroutine


import kotlinx.coroutines.*

fun getId4(): Int {
    println("getID4: ${Thread.currentThread().name}")
    Thread.sleep(500)
    return 44
}

fun getUser4(id: Int): String {
    println("getUser4: ${Thread.currentThread().name}")
    Thread.sleep(900)
    return "getUser($id)"
}

fun getInfo4(user: String): String {
    println("getInfo4: ${Thread.currentThread().name}")
    Thread.sleep(600)
    return "getInfo($user)"
}

suspend fun foo4() {
    coroutineScope {
        val id = async { getId4() }
        val user = async { getUser4(id.await()) }
        val info = async { getInfo4(user.await()) }
        println("szw 4 info = ${info.await()}")
    }
}

suspend fun main() {
    foo4()
}

/*
getID4: DefaultDispatcher-worker-1
getUser4: DefaultDispatcher-worker-1
getInfo4: DefaultDispatcher-worker-1
szw 4 info = getInfo(getUser(44))
 */