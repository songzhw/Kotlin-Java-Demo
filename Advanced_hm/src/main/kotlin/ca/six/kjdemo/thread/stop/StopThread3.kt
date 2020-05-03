package ca.six.kjdemo.thread.stop

class Stop03(val name: String, var isRunning: Boolean) : Runnable {
    override fun run() {
        while (isRunning) {
            Thread.sleep(200)
            println("szw thread($name) running")
        }
        println("szw thread stop")
    }
}


fun main() {
    val r = Stop03("C3", true)
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
szw thread(C3) running
szw thread stop

  可见仍不保险

 */