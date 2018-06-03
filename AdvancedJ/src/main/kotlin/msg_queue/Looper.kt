package msg_queue

import java.util.function.Supplier

object Looper {

}


class Temp {

    fun getMessageQueue() {

    }

    fun quit() {

    }

    companion object {

        internal var localLooper = ThreadLocal.withInitial { "" }

        fun myLooper(): String {
            return localLooper.get()
        }

        fun loop() {

        }
    }

}

fun main(args: Array<String>) {
    Temp.loop()
}