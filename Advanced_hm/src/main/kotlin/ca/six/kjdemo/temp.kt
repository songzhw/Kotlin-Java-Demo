package ca.six.kjdemo

import java.util.*
import kotlin.experimental.xor

fun main() {
    val MOD = 20
//    val data = byteArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90)
    val data = byteArrayOf(10, 29, 22, 47, 53, 58, 67, 84, 89)
    val key = byteArrayOf(0, 9, 8, 7, 7, 6, 5, 4, 3, 2, 1)
    val size = data.size
    for (i in 0 until size) {
        data[i] = data[i] xor key[i % MOD]
    }

    print(data.joinToString(","))
}