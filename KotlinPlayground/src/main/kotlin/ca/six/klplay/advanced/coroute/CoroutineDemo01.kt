package ca.six.klplay.advanced.coroute

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

fun foo(){
    launch(CommonPool) {
        delay(1000L)
        println("World")
    }

    print("Hello ")
    Thread.sleep(2000L)
}//=> Hello, 1秒后world. 再1秒后结束应用


fun main(args: Array<String>) {
    foo()
}