package msg_queue

class Handler @JvmOverloads constructor(
        private val looper: Looper = Looper.myLooper(),
        private val callback: Callback? = null) {

    fun dispatchMessage(msg: Message) {
        if(msg.runnableCallback != null) { // msg.runnableCallback是一个Runnable类型
            // 1. handler发的是个Runnable
            msg.runnableCallback?.run()
            return
        } else {
            // 2. handler发的是一个message

            // 2.1 有自定义callback就走callback (一般这种情况少见)
            if(callback != null){
                if(callback.handleMessage(msg)) {
                    return;
                }
            }
            // 2.2 没自定义callback就走Handler自己的handleMessage()
            handleMessage(msg)
        }
    }

    protected fun handleMessage(msg: Message){
    }

    fun sendMessage(msg : Message){
        msg.target = this

        val queue = looper.getMessageQueue()
        queue.enqueue(msg)
    }

    fun sendMessageDelay(msg: Message, delay: Long){
        msg._when = System.currentTimeMillis() + delay
        sendMessage(msg)
    }

    fun post(runnable : Runnable){
        postDelay(runnable, 0)
    }

    fun postDelay(runnable: Runnable, delay : Long){
        val msg = Message()
        msg._when = System.currentTimeMillis() + delay
        msg.runnableCallback = runnable
        sendMessage(msg)
    }




    interface Callback {
        fun handleMessage(msg: Message): Boolean
    }
}


