package basic.thread.lock

class Target {
    @Synchronized fun outer() {
        inner()
    }

    @Synchronized fun inner() {}
}

class MyLock {
    val lock = java.lang.Object();
    var isLocked = false
    var lockedBy: Thread? = null
    var lockedCount = 0

    @Synchronized fun lock() {
        val current = Thread.currentThread()

        while (isLocked && lockedBy !== current) {
            lock.wait() //要写在synchornized里, 不然会crash
        }
        isLocked = true
        lockedCount++
        lockedBy = current
    }

    @Synchronized fun unlock() {
        if (Thread.currentThread() === this.lockedBy) {
            lockedCount--

            if (lockedCount == 0) {
                isLocked = false //上面是while(A & B), 用的是&, 所以这里不让lockedBy = null也是行的
                lock.notify() //要写在synchornized里, 不然会crash
            }
        }

    }
}
