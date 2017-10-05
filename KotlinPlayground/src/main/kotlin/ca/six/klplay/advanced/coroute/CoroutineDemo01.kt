package ca.six.klplay.advanced.coroute

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun foo(){
    launch(CommonPool) {
        delay(1000L)
        println("World")
    }

    print("Hello ")
    Thread.sleep(2000L)
}//=> Hello, 1秒后world. 再1秒后结束应用

fun fo2(){
    launch(CommonPool) {
        delay(1000L)
        println("World")
    }

    print("Hello ")
    Thread.sleep(500L)
} //=> Hello, 半秒后应用结束. (始终没有打印出来world)


fun fo3() = runBlocking<Unit> {
    launch(CommonPool) {
        delay(1000L)
        println("World!")
    }

    print("Hello ")
    delay(2000L)
} //=> 效果类似foo(), 但其实不像Thread.sleep一样会堵塞住


fun fo4() = runBlocking<Unit> {
    launch(CommonPool) {
        delay(1000L)
        println("World!")
    }

    print("Hello ")
    delay(600L)
} //=> 效果类似fo2(), 但其实不像Thread.sleep一样会堵塞住


fun main(args: Array<String>) {
    fo3()
}