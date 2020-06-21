package ca.six.algo.stack_queue

import java.util.*

/*
如输入是[2,1,2,4,3], 要求返回每个元素后面第一个更大的数 (若没有, 就返回-1)
2后面第一个比2更大的数是4; 1后面第一个比1更大的数是2; ...
所以应该返回[4, 2, 4, -1, -1]
 */

fun nextGreater(src: Array<Int>) {
    val ret = arrayOfNulls<Int>(src.size)
    val stack = Stack<Int>()

    //是往后的更大数, 所以使用倒序来遍历src
    for (i in src.size - 1 downTo 0) { //10 downto 8是: 10, 9, 8
        val number = src[i]
        println("($number)" + stack)
        while (!stack.isEmpty() && (stack.peek() <= number)) stack.pop()
        ret[i] = if (stack.empty()) -1 else stack.pop()
        stack.push(number)
    }

    println(ret.asList())
}

fun main() {
    nextGreater(arrayOf(2, 1, 2, 4, 3))
}