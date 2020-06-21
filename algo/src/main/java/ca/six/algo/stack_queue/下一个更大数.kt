package ca.six.algo.stack_queue

/*
如输入是[2,1,2,4,3], 要求返回每个元素后面第一个更大的数 (若没有, 就返回-1)
2后面第一个比2更大的数是4; 1后面第一个比1更大的数是2; ...
所以应该返回[4, 2, 4, -1, -1]
 */

fun nextGreater(src: Array<Int>) {
    val ret = arrayOfNulls<Int>(src.size)
    println(ret.asList())
}

fun main() {
    nextGreater(arrayOf(2, 1, 2, 4, 3))
}