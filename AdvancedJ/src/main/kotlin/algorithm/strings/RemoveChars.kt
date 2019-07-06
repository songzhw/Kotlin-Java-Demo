package algorithm.strings

import java.util.*

fun remove(src: String, delete: String): String {
    val bits = BitSet(128)
    for (c in delete.toCharArray()) {
        val index = c.toInt()
        bits.set(index)
    }

    val list = arrayListOf<Char>()
    for (c in src) {
        val index = c.toInt()
        if (!bits.get(index)) { //if is not set
            list.add(c)
        }
    }
    return String(list.toCharArray())
}

fun main() {
    println(remove("java coffee", "aof"))
}

/*
    val c = 'a'
    println(c.toInt()) //=>97
 */