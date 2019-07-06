package algorithm.strings

import java.util.*

fun remove(src: String, delete: String): String {
    val bits = BitSet(128)
    for (c in delete.toCharArray()) {
        val index = c.toInt()
        bits.set(index)
    }

    val chars = charArrayOf()
    var i = 0;
    for (c in src) {
        val index = c.toInt()
        if (!bits.get(index)) { //if is not set
            chars[i] = c
            i++
        }
    }
    return String(chars)
}

fun main() {
//    println(remove("java coffee", "aof"))
    val chars = charArrayOf()
    chars[0] = 'a'
}

/*
    val c = 'a'
    println(c.toInt()) //=>97
 */