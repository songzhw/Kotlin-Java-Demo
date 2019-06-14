package coroutine

import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
        println("World! (${printTime()})") // 在延迟后打印输出
    }
    println("Hello, (${printTime()})") // 协程已在等待时主线程还在继续
    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    println("---- end --- (${printTime()})")
}

fun printTime(): String{
    val nowTime = LocalDateTime.now()
    var formatter = DateTimeFormatter.ofPattern("hh:mm:ss:SSS")
    val now = nowTime.format(formatter)
    return now
}
/*
Hello, (02:35:05:857)
World! (02:35:06:776)
---- end --- (02:35:07:881)
 */