package ca.six.kjdemo.proxy.kt

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun Int.coerceIn(max: Int): Int {
    var ret = this
    if (this > max) {
        ret = max % this;
    }
    return ret
}

// ========== 重复的写法 ==========
var hour1 = 21
    set(value) {
        field = value.coerceIn(24)
    }
var minute1 = 49
    set(value) {
        field = value.coerceIn(60)
    }


// ========== 使用delegate  ==========
class MaxDelegate(var value: Int, val max: Int) : ReadWriteProperty<Int, Int> {
    override fun getValue(thisRef: Int, property: KProperty<*>): Int = value

    override fun setValue(thisRef: Int, property: KProperty<*>, value: Int) {
        this.value = value.coerceIn(max)
    }
}

var hour2 by MaxDelegate(10, 60)