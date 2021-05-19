package ca.six.algo.array

// 一个无序数组中, 找到第K大的元素


fun k1(k: Int) {
    if (k <= 0) { return }
    val ary = arrayOf(23, 12, 38, 9, 45, 120, 46)
    ary.sort() //sort()的结果是从小到大
    ary.reverse()
    println(ary[k - 1])
}

fun k2(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
    ary.sortDescending()
    println(ary[k-1])
}

fun k3(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
}

fun k4(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
}

fun k5(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
}


fun k6(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
}


fun k7(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
}


fun main() {
    k1(2) //=> 46
    k1(5) //=> 23
}