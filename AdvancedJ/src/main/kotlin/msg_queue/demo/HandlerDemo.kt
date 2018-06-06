package msg_queue.demo

import msg_queue.*

class HandlerDemo {

}

// 没效果. 可能是looper没有启动
fun main(args: Array<String>) {
    val handler = object: Handler() {
        override fun handleMessage(msg: Message) {
            println("szw handler handleMesage(${msg.what} - ${msg.obj})")
        }
    }

    val msg = Message()
    msg.what = 11
    msg.obj = "test" //要是obj是Object类型, 这就会报错. 正确得是Any类型

    handler.sendMessage(msg)

}