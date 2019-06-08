package ca.six.algo.array

//不额外使用其它空间, 原地删除一个排序数组中的重复项
fun main() {
    val ary = intArrayOf(1, 1, 2, 3, 3, 3, 3, 4)
    approach1(ary)
}

fun approach1(ary: IntArray) {
    ary.forEachIndexed { index, number ->
        var next = ary[index + 1]
        var sameCount = 0
        while (next == number) {
            sameCount++
            next = ary[index + 1 + sameCount]
        }


    }
}