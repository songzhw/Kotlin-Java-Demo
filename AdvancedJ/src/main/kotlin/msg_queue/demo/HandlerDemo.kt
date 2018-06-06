package msg_queue.demo

import msg_queue.*
import kotlin.concurrent.thread

fun main1(args: Array<String>) {
    val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            println("szw handler handleMesage(${msg.what})")
        }
    }

    val msg = Message()
    msg.what = 11
    msg.obj = "test" //要是obj是Object类型, 这就会报错. 正确得是Any类型

    handler.sendMessage(msg)
    handler.sendMessageDelay(Message(), 1000)
    handler.sendMessageDelay(Message(), 2000)
    handler.sendMessageDelay(Message(), 4000)

    // 省略了Looper.prepare()
    println("01")
    Looper.loop()
    println("02")  //=> 这一句永远就不执行了

}

fun main(args: Array<String>) {
    // 不加isDaemon=true, 就报错 "Exception in thread "main" java.lang.IllegalThreadStateException"
    thread(start = true, isDaemon = true) {
        val handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                println("szw handler handleMesage(${msg.what})")
            }
        }

        val msg = Message()
        msg.what = 11
        msg.obj = "test" //要是obj是Object类型, 这就会报错. 正确得是Any类型

        handler.sendMessage(msg)

        println("011")
        Looper.loop()
        println("022") // 不会执行到这一句

    }.join() //加了join, 就一直在等此线程完结. 但此线程因为loop()死循环, 一直不结束, 所以main()方法也一直不结束
}