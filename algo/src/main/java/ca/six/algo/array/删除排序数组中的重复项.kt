package ca.six.algo.array

//不额外使用其它空间, 原地删除一个排序数组中的重复项, 返回不重复数组的长度
// 备注: 用C链表自然容易原地删除; 但java就麻烦些, 因为不能一边遍历数组一边修改数组
// 由答案可知, 其实主是返回个不重复数字的长度就好了, 又不用返回新数组
fun main() {
    val ary = intArrayOf(1, 1, 2, 3, 3, 3, 3, 4)
    println("new size = ${approach2(ary)}")  //=> new size = 4
}

fun wrongAnswer(ary: IntArray) {
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

fun approach2(ary: IntArray): Int {
    if (ary.isEmpty()) {
        return 0
    }
    var i = 0
    for (j in 1 until ary.size) {
        if (ary[j] != ary[i]) {
            i++  //值不等时才自增, 所以这个i也代表了新数组了长度
            ary[i] = ary[j]
        }
    }

    ary.forEach{ println(it)} //=> 其实仍是12343334
    return i + 1
}