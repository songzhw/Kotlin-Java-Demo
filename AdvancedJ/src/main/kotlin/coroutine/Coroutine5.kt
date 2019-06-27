package coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun co1() {
    GlobalScope.launch {
        delay(1000)
        println("1")
        launch {
            delay(4000)
            println("3")
        }
        println("2")
    }
    println("4")
}

//fun main() {
//    co1()  //=> 打印完4, 立马就结束了 (JVM嘛)
//}

// =========================


suspend fun co2() {
    coroutineScope {
        delay(1000)
        println("1")
        launch {
            delay(4000)
            println("3")
        }
        println("2")
    }
    println("4")
}

suspend fun main() {
    co2() //=> 1秒后,   打印出 1, 2; 再4秒后, 打印出 3, 4
}
