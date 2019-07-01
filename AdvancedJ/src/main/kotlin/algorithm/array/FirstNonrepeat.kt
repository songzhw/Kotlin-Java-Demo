package algorithm.array

fun findFirstNonRepeated(ary: IntArray): Int {
    val map = hashMapOf<Int, Int>()
    for (num in ary) {
        val count = if (map.get(num) != null) map.get(num) else 0;
        val newCount = count!! + 1
        map.set(num, newCount)
    }

    for (num in ary) {
        val count = map.get(num)
        if (count == 1) {
            return num;
        }
    }
    return -1
}

fun main() {
    val num = findFirstNonRepeated(intArrayOf(1, 1, 3, 4, 5, 7, 4, 7, 5, 0, 5, 3))
    println(num) //=> 0
}