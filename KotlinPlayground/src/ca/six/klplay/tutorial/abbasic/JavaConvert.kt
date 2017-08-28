package ca.six.klplay.tutorial.abbasic

import java.util.concurrent.atomic.AtomicInteger

class CallArbiter : AtomicInteger() {
    override fun toByte(): Byte {
        return 1
    }

    override fun toChar(): Char {
        return 's'
    }

    override fun toShort(): Short {
        return 1
    }

}
