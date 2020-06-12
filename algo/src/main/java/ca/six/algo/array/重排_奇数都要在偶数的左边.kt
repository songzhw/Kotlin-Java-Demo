package ca.six.algo.array

import java.util.*


fun rearrange1(ary: IntArray) {
    val extra = LinkedList<Int>()
    ary.forEach { item ->
        if (item % 2 == 0) {
            extra.add(item)  // 加在末尾
        } else {
            extra.push(item)  // 加在开头
        }
        //=> [3], [3,8], [3,8,4], [1,3,8,4], ...
    }
    println(extra) //=> [7, 1, 3, 8, 4, 2]
}


fun rearrange2(ary: IntArray) {

}

fun main() {
    val ary = intArrayOf(3, 8, 4, 1, 2, 7)
    rearrange1(ary)  // O(n)
    rearrange2(ary)  // O(n)
}