package algorithm.sort

import utils.swap

// unsorted array consisting of consecutive integers
fun minSwaps(ary: Array<Int>): Int {
    // 若第零位是3, 那我就要把第零位和第三位互换 -- 因为数字就代表我的位置, 所以我先移动一下, 至少先把第零位上的数字放到正确的位置
    // 现在再对新的第零位, 重复一样的动作.

    var swapTimes = 0
    val size = ary.size
    var i = 0
    while (i < size) {
        if (ary[i] == i) {
            i++
            continue
        }

        ary.swap(i, ary[i])
        swapTimes++
        //这里就不再 i++ 了, 因为我还要比较第i位的数字是不是i, 所以i仍是原样进入下一循环单次
    }
    return swapTimes

}



fun main(args: Array<String>) {
    val ary1 = intArrayOf(3, 2, 0, 1).toTypedArray()
    println("min01 = ${minSwaps(ary1)}")  //=> 3

    val ary2 = intArrayOf(1, 2, 3, 0, 4).toTypedArray()
    println("min02 = ${minSwaps(ary2)}")  //=> 3


}