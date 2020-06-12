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
    var first = 0
    var last = ary.size - 1
    while (first < last) {
        val firstValue = ary[first]
        val lastValue = ary[last]
        if (firstValue % 2 == 0 && lastValue % 2 == 1) {
            val temp = ary[first]; ary[first] = ary[last];ary[last] = temp;
        }
        first++;
        if (lastValue % 2 == 0) last--;
    }
    ary.forEach { print("$it, ") }
}

fun main() {
    val ary = intArrayOf(3, 8, 6, 4, 1, 2, 7, 9, 12)
    rearrange1(ary)  // O(n)
    rearrange2(ary)  // O(n)
}