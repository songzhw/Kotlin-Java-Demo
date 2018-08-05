package algorithm

fun minBribes(line : Array<Int>){
    line.forEachIndexed { index, item ->
        val supposedToBe = item
        val now = index+1 //因为index是从0开始的. 但题目中队伍队列是从1开始
        if(supposedToBe - now > 2){
            println("Too chaotic")
        }
    }
    println(" - - - - - - - - - - -")
}

fun main(args: Array<String>) {
    val ary1 = intArrayOf(3, 2, 1) // 1,3,2   3,1,2   3,2,1
    minBribes(ary1.toTypedArray()) // toTypeArray()就是把IntArray转成Array<Int>


    val ary2 = intArrayOf(4, 1, 2, 3).toTypedArray()
    minBribes(ary2) //=> Too chaotic
}