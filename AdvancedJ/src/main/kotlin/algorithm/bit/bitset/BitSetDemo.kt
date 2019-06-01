package algorithm.bit.bitset

import java.util.*

// 题目: 找到[0-10]之间, 没有出现过的数字.
fun findMissings(input: Array<Int>) {
    val bits = BitSet() // 默认是64位
    for (num in input) {
        bits.set(num); //将index位设为true
    }
    println("出现过${bits.size()}个不重复数字") //=> 64

    // 找出没有出现的数字 (kotlin中, 0..10是[0,10], 0 until 10是[0, 10)
    for (index in 0 until 10) {
        val isExisting = bits.get(index)  //返回boolean
        if (!isExisting) {
            println("${index} is missing")
        }//=> 2,4,7,8 are missing
    }
}

fun main(args: Array<String>) {
    val ary = arrayOf(0, 1, 3, 5, 1, 9, 1, 6, 9); // 2,4,7,8 are missing
    findMissings(ary)
}

/*
类似的题还有: "一个老式手机, 只能存256条短信. 每次来个短信就分配个id, id是在[0-255]之间的. 用户可以删除短信. 现在要求, 在还没有用完256条短信的情况下, 来了个新短信, 请你用一个算法来给这个新短信分配个id."
: 这其实就是找[0-255]中有哪些id是空的嘛
这是不是和上面的做法是一样的, 时空复杂条O(n), 空间复杂度更是超级小.
 */