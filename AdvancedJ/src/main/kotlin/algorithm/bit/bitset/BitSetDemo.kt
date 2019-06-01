package algorithm.bit.bitset

import java.util.*

// 题目: 找到[0-10]之间, 没有出现过的数字.
fun findMissings(input: Array<Int>) {
    val bits = BitSet() // 默认是64位
    for (num in input) {
        bits.set(num);
    }
    println("出现过${bits.size()}个不重复数字") //=> 64

    // 找出没有出现的数字 (kotlin中, 0..10是[0,10], 0 until 10是[0, 10)
    for (index in 0 until 10) {
        val isExisting = bits.get(index)
        if (!isExisting) {
            println("${index} is missing")
        }//=> 2,4,7,8 are missing
    }
}

fun main(args: Array<String>) {
    val ary = arrayOf(0, 1, 3, 5, 1, 9, 1, 6, 9); // 2,4,7,8 are missing
    findMissings(ary)
}