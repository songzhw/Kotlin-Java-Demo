package ca.six.kjdemo.thread.stop

class ToStop01(name: String) : Thread(name) {
    override fun run() {
        while (!isInterrupted) {
            println("szw thread($name} running")
        }
        println("szw thread stop!!!")
    }
}

fun main() {
    val t = ToStop01("A1")
    t.start()

    Thread.sleep(500)
    println("szw main stop thread")
    t.interrupt()
}

/*
 日志是:
szw thread(A1} running
... ...
szw thread(A1} running
szw thread(A1} running
szw thread(A1} running
szw main stop thread
szw thread(A1} running
szw thread(A1} running
szw thread stop!!!

明明已经interrupte了, 但thread还是多运行了一段时间. 所以说interrupt()来终止线程是不靠谱的
 */