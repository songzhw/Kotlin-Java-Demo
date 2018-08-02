package algorithm.frequency

/*
找出一个数组中出现超过一半的数字. 如[1, 2, 2, 2, 3]中就是2了
--> 变种: 找出其中没超过一半的数字
--> 变种: 找到其中只出现过一次的数字
--> 变种: 找到其中只出现过两次的数字
...
 */

fun appraoch01(nums: IntArray) : Int{
    val map : HashMap<Int, Int> = HashMap()

    // analyze every items in array
    for(number in nums){
        if(!map.containsKey(number)){
            map.put(number, 1)
        } else {
            val times =  map.get(number)!! + 1 // "!!"是保证get()的结果不是Int?, 而是Int, 不然不能+1, 因为+1其实就是plus(1)
            map.put(number, times)
        }
    }

    // iterate the map, to get the result
    var ret = Int.MIN_VALUE
    map.forEach { k, v ->
        if(v > nums.size/2){
            ret = k
        }
    }


    if(ret != Int.MIN_VALUE){
        return ret
    } else {
        throw Exception("No such items")
    }
}

fun main(args: Array<String>) {
    val ary1 = intArrayOf(6, 2, 2, 2, 3)
    val ary2 = intArrayOf(2, 4, 3)

    try {
        println("ary1 = " + appraoch01(ary1))
        println("ary2 = " + appraoch01(ary2))
    } catch(e : Exception){
        println("no such item")
    }


}