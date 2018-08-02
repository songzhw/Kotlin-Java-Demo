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

// 检查每个数, +1或-1, 这样过半数的那个数字, 肯定times会>0
fun appraoch02(nums : IntArray) : Int{
    var ret = nums[0]
    var times = 0

    for(number in nums){
        if(times == 0){
            ret = number
            times = 1
        } else if(number == ret){
            times++;
        } else {
            times--;
        }
    }

    // 不能光用times>0来判断, 因为{1, 2, 3}也会让times > 0. 所以我们还要检查是否过半
    times = 0
    for(number in nums){
       if(number == ret){
           times++;
       }
    }
    if(times > nums.size / 2){
        return ret
    } else {
        throw Exception("no such item 222")
    }

    return times
}


fun main(args: Array<String>) {
    val ary1 = intArrayOf(6, 2, 2, 2, 3)
    val ary2 = intArrayOf(2, 4, 3)

    // 方法一: 可行. 且适用于上面的各种变种情况. 但是, 需要额外的空间for hashmap
    try {
        println("ary1 = " + appraoch01(ary1))
        println("ary2 = " + appraoch01(ary2))
    } catch(e : Exception){
        println("no such item")
    }

    // 方法二: 可行. 不需要HashMap额外空间, 但不适用于上面的各种变种问题.
    try {
        println("ary1 = " + appraoch02(ary1))
        println("ary2 = " + appraoch02(ary2))
    } catch(e : Exception){
        println("no such item2")
    }

}