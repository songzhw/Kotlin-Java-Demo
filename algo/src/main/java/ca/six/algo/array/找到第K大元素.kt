package ca.six.algo.array

import java.util.*
import kotlin.collections.ArrayList

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

// 我们只关心第K大, 并不强求第K大之后的数组是无序还是有序的, 所以现在可以改O(nlogn)为O(n * K), 在数组极大时约等于O(n)
fun k3(k: Int) {
    if (k <= 0) { return }
    val ary = arrayListOf(23, 12, 38, 9, 45, 120, 46)


    val maxNumbers = arrayListOf<Int>()
    for(i in 1..k){
        getMax(ary, maxNumbers)
    }
    println(maxNumbers[0])
}

private fun getMax(from: ArrayList<Int>, exception: ArrayList<Int>): Int {
    var max = Int.MIN_VALUE
    for(num in from){
        if(num > max && !exception.contains(num)) {
            max = num
        }
    }
    exception.add(0, max)
    return max
}

fun k4(k: Int) {
    if (k <= 0) { return }
    val ary = intArrayOf(23, 12, 38, 9, 45, 120, 46)
    val heap = PriorityQueue<Int>(k) //java.util.PriorityQueue是最小堆
    for(num in ary){
        heap.add(num) //会重新排序的
        if(heap.size > k){
            heap.poll() //把最小值给弄出去
        }
    }
    println(heap.peek()) //peek()就是最root值. 最小堆中就是最小值.
    // 因为heap的size就是K, 所以这个peek()出的最小值, 就是整个数组的第K大元素
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
    k4(2) //=> 46
    k4(5) //=> 23
}