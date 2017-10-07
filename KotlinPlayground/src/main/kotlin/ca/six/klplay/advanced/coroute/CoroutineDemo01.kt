package ca.six.klplay.advanced.coroute

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun foo(){
    launch(CommonPool) {
        delay(1000L)
        println("World1")
    }

    print("Hello ")
    Thread.sleep(2000L)
}//=> Hello, 1秒后world. 再1秒后结束应用

fun fo2(){
    launch(CommonPool) {
        delay(1000L)
        println("World2")
    }

    print("Hello ")
    Thread.sleep(500L)
} //=> Hello, 半秒后应用结束. (始终没有打印出来world)


// Thread.sleep 会阻塞主线程，而非阻塞函数 delay 只会延迟协程的执行
fun fo3() = runBlocking<Unit> {
    launch(CommonPool) {
        delay(1000L)
        println("World3!")
    }

    print("Hello ")
    delay(2000L)
} //=> 效果类似foo(), 但其实不像Thread.sleep一样会堵塞住


fun fo4() = runBlocking<Unit> {
    launch(CommonPool) {
        delay(1000L)
        println("World4!")
    }

    print("Hello ")
    delay(600L)
} //=> 效果类似fo2(), 但其实不像Thread.sleep一样会堵塞住

// join(): 等待协程的工作完
fun fo5() = runBlocking<Unit> {
    val job = launch(CommonPool){
        delay(1000)
        println ("World5")
    }
    print("Hello ")
    job.join()
}

fun main(args: Array<String>) {
    fo5()
}

// https://baiyangcao.github.io/notes/2017/06/20/kotlin-coroutines.html