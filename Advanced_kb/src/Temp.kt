class One{}

class Th {
    val lock = One()
    @Throws(InterruptedException::class)
    fun watch() {
        println("I wait()")
        synchronized(lock) { lock.wait() }
    }

    fun onWatchOver() { // release the lock
        synchronized(lock) { lock.notify() }
    }
}