package ca.six.algo.array


fun main() {
    val ary2 = IntArray(20) // 这样有空位来存ary1的数字. 其初始值是20个0
    ary2[0] = 1
    ary2[1] = 3
    ary2[2] = 12
    val ary1 = arrayOf(3, 5, 9, 11, 13)

    ary2.forEach { println(it) }
}
