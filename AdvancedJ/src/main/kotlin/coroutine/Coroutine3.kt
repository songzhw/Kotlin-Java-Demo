package coroutine

import kotlinx.coroutines.*

fun getId3(): Int {
    println("getID3: ${Thread.currentThread().name}")
    Thread.sleep(500)
    return 33
}

fun getUser3(id: Int): String {
    println("getUser3: ${Thread.currentThread().name}")
    Thread.sleep(900)
    return "getUser($id)"
}

fun getInfo3(user: String): String {
    println("getInfo3: ${Thread.currentThread().name}")
    Thread.sleep(600)
    return "getInfo($user)"
}

fun main() = runBlocking {
    val id = async { getId3() }
    val user = async {getUser3(id.await())}
    val info = async {getInfo3(user.await())}
    println("szw 3 info = ${info.await()}")
}

/*
getID3: main
getUser3: main
getInfo3: main
szw 3 info = getInfo(getUser(33))
 */