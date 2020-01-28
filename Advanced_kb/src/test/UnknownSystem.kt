package test

class UnknownSystem(val worker: UnknownWorker) {

    fun add(arg1: Int, arg2: Int): Int {
        return arg1 + arg2
    }

    fun command(arg: Int) {
        worker.work(arg)
    }


}

class UnknownWorker {
    fun work(arg: Int): Int {
        return arg * arg + arg
    }
}