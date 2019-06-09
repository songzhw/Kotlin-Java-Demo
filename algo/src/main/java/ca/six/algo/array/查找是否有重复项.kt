package ca.six.algo.array


fun isUnique(ary: IntArray) {
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

fun main() {
    val ary1 = intArrayOf(0, 1, 2, 3, 4, 2, 5)
    isUnique(ary1)

    val ary2 = intArrayOf(0, 1, 2, 3, 4, 6, 5)
    isUnique(ary2)
}