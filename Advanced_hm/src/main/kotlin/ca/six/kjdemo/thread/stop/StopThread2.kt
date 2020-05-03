package ca.six.kjdemo.thread.stop


class ToStop02(name: String) : Thread(name) {
    override fun run() {
        while (!isInterrupted) {
            Thread.sleep(200)
            println("szw thread($name} running")
        }
        println("szw thread stop!!!")
    }
}

fun main() {
    val t = ToStop02("A1")
    t.start()

    Thread.sleep(500)
    println("szw main stop thread")
    t.interrupt()
}

/*
 日志是:
szw thread(A1} running
szw thread(A1} running
szw main stop thread
Exception in thread "A1" java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at ca.six.kjdemo.thread.stop.ToStop02.run(StopThread2.kt:7)


当线程处于阻塞状态  (如sleep,  同步锁的wait,    socket中的receiver()/accept() ..)
这时去调用thread.interrupt(), 就会把抛出 InterruptException.
 */