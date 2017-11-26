package ca.six.klplay.advanced.extension

fun Long.sleep( workLater : () -> Unit){
    Thread.sleep(this)
    workLater()  // 不用调用什么workLater.invoke()等方法, 直接写workLater()就是调用此方法了
}

fun main(args: Array<String>) {
    println("szw start")
    2000L.sleep {
        println("szw after sleep")
    }
    println("szw end")

}