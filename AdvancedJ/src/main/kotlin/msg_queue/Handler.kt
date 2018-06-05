package msg_queue

class Handler @JvmOverloads constructor(
        private val looper: Looper = Looper.myLooper(),
        private val callback: Callback? = null) {

    fun dispatchMessage(msg: Message) {

    }

    interface Callback {
        fun handleMessage(msg: Message): Boolean
    }
}


