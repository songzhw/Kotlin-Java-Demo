package basic.thread.lock

class Target {
    @Synchronized fun outer() {
        inner()
    }

    @Synchronized fun inner() {}
}

class Lock {
    private var isLocked = false
    private val lock = java.lang.Object()

    @Synchronized fun lock(){
        while(isLocked){
            lock.wait()
        }
        isLocked = true
    }

    @Synchronized fun unlock(){
        isLocked = false
        lock.notify()
    }
}

