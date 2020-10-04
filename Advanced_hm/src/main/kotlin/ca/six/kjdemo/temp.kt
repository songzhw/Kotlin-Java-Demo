package ca.six.kjdemo

import java.util.*
import kotlin.experimental.xor

fun main() {
    val MOD = 20
//    val data = "ObfuscatedFonts123".toByteArray()
//    val data = byteArrayOf(10, 20, 30, 40)
    val data = byteArrayOf(13, 18, 27, 44)
    val key = byteArrayOf(7, 6, 5, 4, 3, 2, 1)
    val size = data.size
    for (i in 0 until size) {
        data[i] = data[i] xor key[i % MOD]
    }

//    print(Base64.getEncoder().encodeToString(data))
//    print(String(data))
    data.forEach { print("$it,") }
}

//=> AAAAAAAAAAAMCygkCw1KCQUF
