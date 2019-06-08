package ca.six.algo.array

//不额外使用其它空间, 原地删除一个排序数组中的重复项
// 备注: 用C链表自然容易原地删除; 但java就麻烦些, 因为不能一边遍历数组一边修改数组
fun main() {
    val ary = intArrayOf(1, 1, 2, 3, 3, 3, 3, 4)
    approach1(ary)
    val a2 = doubleArrayOf(0.1, 0.2)
}

fun approach1(ary: IntArray) {
    ary.forEachIndexed { index, number ->
        if (index + 1 >= ary.size) {
            return@forEachIndexed  //不能直接return, 不然就是直接从方法中返回, 就不会有println(ary)了
        }
        var next = ary[index + 1]
        var sameCount = 0
        var nextIndex = index + 1
        while (next == number) {
            sameCount++
            nextIndex = index + 1 + sameCount
            next = ary[nextIndex]
        }

        ary.forEachIndexed { idx2, num2 ->
            if (sameCount > 0 && idx2 == index + 1) {
                ary[idx2] = ary[nextIndex]
                sameCount--
            }
        }
    }

    ary.forEach { println(it) }
} //=> 1, 2, 3, 4, 3, 4, 3, 4