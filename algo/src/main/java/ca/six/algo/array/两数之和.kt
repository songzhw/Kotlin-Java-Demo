package ca.six.algo.array

/*
给定一个数组与值A,  在数组中找到和为A的两个整数, 返回这两个整数的下标
如输入是[2, 3, 7, 11]与9, 那就要返回[0, 2]
 */

fun main() {
    val ary = intArrayOf(2, 3, 7, 11)
    val target = 9
    approach1(ary, target)
    approach2(ary, target)
    approach3(ary, target)
}

fun approach1(ary: IntArray, target: Int) {
    ary.forEachIndexed{index1, i ->
        ary.forEachIndexed{index2, j ->
            if(i + j == target){
                println("index1 = [$index1, $index2]")
                return  //不加这个, 就有两处结果[0, 2] 与 [2, 0]
            }
        }
    }
    println("=============")
}

fun approach2(ary: IntArray, target: Int) {

    println("=============")
}

fun approach3(ary: IntArray, target: Int) {

    println("=============")
}