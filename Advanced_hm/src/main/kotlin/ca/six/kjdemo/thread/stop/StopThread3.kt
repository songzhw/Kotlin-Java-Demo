package ca.six.kjdemo.thread.stop

class Stop03(val name: String) : Runnable {
    @Volatile
    var isRunning: Boolean = true

    override fun run() {
        while (isRunning) {
            Thread.sleep(200)
            // 双层加锁
            if (isRunning) {
                println("szw thread($name) running")
            }
        }
        println("szw thread stop")
    }
}


fun main() {
    val r = Stop03("C3")
    val t = Thread(r)
    t.start()

    Thread.sleep(500)
    r.isRunning = false;
    println("szw main stop thread")
}

/*
 log:
szw thread(C3) running
szw thread(C3) running
szw main stop thread
szw thread stop
 */