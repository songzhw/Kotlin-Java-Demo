package ca.six.klplay.advanced.extension

fun Long.sleep(workLater: () -> Unit) {
    Thread {
        Thread.sleep(this)
        workLater()  // 不用调用什么workLater.invoke()等方法, 直接写workLater()就是调用此方法了
    }.start()
}

fun main(args: Array<String>) {
    println("szw start  ${Thread.currentThread().name}")
    2000L.sleep {
        println("szw after sleep ${Thread.currentThread().name}")
    }
    println("szw end  ${Thread.currentThread().name}")

}
/*
自然是先打印szw start main 与 szw end main (几乎是同时打印出来, 只差一点时间差)
2秒后再打印出来: szw after sleep Thread-0
 */