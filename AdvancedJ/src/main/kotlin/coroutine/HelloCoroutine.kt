package coroutine

import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（只delay, 不会阻塞协程）
        println("World! (${printTime()})") // 在延迟后打印输出
    }

    thread {
        Thread.sleep(300)
        println("01 (${printTime()})")
    }
    thread {
        Thread.sleep(400)
        println("02 (${printTime()})")
    }
    GlobalScope.launch {
        // 在后台启动一个新的协程并继续
        delay(500L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("03! (${printTime()})") // 在延迟后打印输出
    }

    println("Hello, (${printTime()})") // 协程已在等待时主线程还在继续
    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    println("---- end --- (${printTime()})")
}

fun printTime(): String {
    val nowTime = LocalDateTime.now()
    var formatter = DateTimeFormatter.ofPattern("hh:mm:ss:SSS")
    val now = nowTime.format(formatter)
    val info = "$now, [${Thread.currentThread().name}]"
    return info
}
/*
GlobalScope里走的是一个新线程, 下面日志可见:

Hello, (10:18:50:200, [main])
World! (10:18:51:137, [DefaultDispatcher-worker-1])
---- end --- (10:18:52:216, [main])
 */