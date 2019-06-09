package ca.six.algo.array

import java.util.*


fun isUnique_withAdditionalDataStructure(ary: IntArray) {
    val map = hashMapOf<Int, Boolean>()
    ary.forEach { num ->
        if (map.containsKey(num)) {
            println("yes, duplicated found")
            return
        }
        map.put(num, true);
    }
    println("no, they are all unique")
}

fun isUnique_withoutAdditionalDataStructure(ary: IntArray) {
    // 不使用额外空间是不可能, 若用boolean[], 或用BitSet(或Long)是此题的方案
    val bits = BitSet()
    for(num in ary){
        val isExisting = bits.get(num)
        if(isExisting){
            println("有重复项!")
            return
        }
        bits.set(num)
    }
    println("全是单个的.")
}

fun main() {
    val ary1 = intArrayOf(0, 1, 2, 3, 4, 2, 5)
    isUnique_withAdditionalDataStructure(ary1)
    isUnique_withoutAdditionalDataStructure(ary1)

    val ary2 = intArrayOf(0, 1, 2, 3, 4, 6, 5)
    isUnique_withAdditionalDataStructure(ary2)
    isUnique_withoutAdditionalDataStructure(ary2)
}