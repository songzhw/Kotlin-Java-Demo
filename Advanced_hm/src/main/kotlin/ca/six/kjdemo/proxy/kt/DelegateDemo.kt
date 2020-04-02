package ca.six.kjdemo.proxy.kt

interface IWorkJob {
    fun work()
}

class FetchDataWorkJob : IWorkJob {
    override fun work() {
        println("http working...")
    }
}

class LogWorkJob(val bizJob: IWorkJob): IWorkJob by bizJob {
    override fun work() {
        println("=== before log === (${System.currentTimeMillis()})")
        bizJob.work()
        println("=== after log === (${System.currentTimeMillis()})")
    }
}
//TODO another wrapper

fun main() {
    val fetcher = FetchDataWorkJob()
    val worker = LogWorkJob(fetcher)
    worker.work()
}