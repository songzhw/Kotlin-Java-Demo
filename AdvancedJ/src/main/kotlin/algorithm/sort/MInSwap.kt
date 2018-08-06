package algorithm.sort

fun minSwaps(ary : Array<Int>): Int {

    return 0
}

fun main(args: Array<String>) {
    val ary1 = intArrayOf(4, 3, 1, 2).toTypedArray()
    println("min01 = ${minSwaps(ary1)}")  //=> 3

    val ary2 = intArrayOf(2, 3, 4, 1, 5).toTypedArray()
    println("min01 = ${minSwaps(ary2)}")  //=> 3
}