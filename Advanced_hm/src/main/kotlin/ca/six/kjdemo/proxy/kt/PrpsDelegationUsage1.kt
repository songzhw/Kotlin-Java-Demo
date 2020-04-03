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

