package algorithm

import exchange
import kotlin.math.max

fun minBribes(line: Array<Int>) {

    var minBribes = 0

    line.forEachIndexed { index, item ->
        // 先看下是否有人破坏规矩(bride超过2次)
        val supposedToBe = item
        val now = index + 1 //因为index是从0开始的. 但题目中队伍队列是从1开始
        if (supposedToBe - now > 2) {
            println("Too chaotic")
            return
        }

        val maxMoveTo = supposedToBe - 2 //最多移动两次.
        val start = max(0, maxMoveTo) // maxMoveTo可能是负数, 所以要让其至少 >= 0
        for (tmpIndex2 in start until index) {
            if (line[tmpIndex2] > line[index]) {
                minBribes++;
            }
        }
    }
    println("minBribes = $minBribes")

    println(" - - - - - - - - - - -")
}


fun minBribes2(line: Array<Int>) {

    var minBribes = 0
    line.forEachIndexed { index, item ->
        // 先看下是否有人破坏规矩(bride超过2次)
        val supposedToBe = item
        val now = index + 1 //因为index是从0开始的. 但题目中队伍队列是从1开始
        if (supposedToBe - now > 2) {
            println("Too chaotic")
            return
        }
    }

    val lastIndex = line.size -1 // 这样后面的line[j+1]才不会IndexOutOfBoundary
    for(i in 0 until lastIndex){
        for(j in 0 until lastIndex){
            if(line[j] > line[j+1]){
                line.exchange(j, j+1)
                minBribes++
            }
        }
    }


    println("minBribes(2) = $minBribes")
    println("\n - - - - - - - - - - -")
}

fun main(args: Array<String>) {
    val ary1 = intArrayOf(3, 2, 1) // 1,3,2   3,1,2   3,2,1
    minBribes2(ary1.toTypedArray()) // toTypeArray()就是把IntArray转成Array<Int>


    val ary2 = intArrayOf(4, 1, 2, 3).toTypedArray()
    minBribes2(ary2) //=> Too chaotic
}