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

fun main() {
    isIncludedIn(1)
    isIncludedIn(18)
    isIncludedIn(39)
    isIncludedIn(90)
}