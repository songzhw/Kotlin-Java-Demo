/*
 二维数组每一行, 每一列都是递增的 (但第二行中的数字不见得都比第一行的大).
 现在给你写一个数字 , 要求返回boolean表示是否输入的数字是否在数组中

 */

package ca.six.algo.array

val ary = arrayOf(
    intArrayOf(2, 8, 12, 19),
    intArrayOf(13, 24, 39, 48),
    intArrayOf(24, 45, 63, 93)
)

/*
// 最基础版的算法, O(n2)

fun isIncludedIn(num: Int) {
    for (subary in ary) {
        for (item in subary) {
            if (item == num) {
                println("[hit] : found $num")
                return
            }
        }
    }
    println("no found: $num")
}
*/

// 利用有序的特点, 变成了O(row+column), 相当于O(n)的效率了
fun isIncludedIn(target: Int) {
    var column = ary[0].size - 1
    var row = 0
    var temp = ary[row][column]

    while (target != temp) {
        if (column <= 0 || row >= ary.size - 1) {
            println("not fould : $target")
            return
        }

        if (target > temp) {
            // column += 1 //不应该是column+=1. column+1就直接越界而crash了
            row += 1
        } else if (target < temp) {
            column -= 1
        }
        temp = ary[row][column]
    }
    println("[hit]: $target")
}

fun main() {
    isIncludedIn(1)
    isIncludedIn(18)
    isIncludedIn(39)
    isIncludedIn(90)
}