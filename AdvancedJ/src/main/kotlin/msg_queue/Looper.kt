package msg_queue

// 暂没写prepare()方法, 直接初始化了threadLocal了
class Looper {
    private val queue : MessageQueue = MessageQueue()

    companion object {

        internal var localLooper: ThreadLocal<Looper> = ThreadLocal.withInitial { Looper() }

        fun myLooper(): Looper {
            return localLooper.get()
        }

        // 消费message
        fun loop() {
            val me = myLooper()
            while(true){
                val msg = me.queue.next()
                if(msg is EmptyMessage) return
                msg.target.dispatchMessage(msg)
            }
        }
    }

    fun getMessageQueue() : MessageQueue {
        return queue
    }

    fun quit() {
        queue.quit()
    }

}

