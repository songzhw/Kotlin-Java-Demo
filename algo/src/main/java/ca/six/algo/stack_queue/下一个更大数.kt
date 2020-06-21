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
        // stack存倒序过来的number, 即number后边的数字; 所以我们就要去遍历stack, 直到找到比stack更大的数
        while (!stack.isEmpty() && (stack.peek() <= number)) stack.pop()
        ret[i] = if (stack.empty()) -1 else stack.peek()
        stack.push(number)
    }

    println(ret.asList())
}

/*
 给定最近几天气温. 现在要返回: 等待多少天才能等到一个更暖和的气温. 如果等不到就返回-1
 比如给定[21, 24, 23, 22, 18, 24, 30, 28], 那就返回: [1, 5, 4, 3, 1, 1, -1, -1]

 思路和上面nextGreater()类似, 只不过输出不是更大的数, 而是自己和下一更大数之间的距离
 */
fun nextWarmer(src: Array<Int>) {
    val ret = arrayOfNulls<Int>(src.size)
    val stack = Stack<Int>()

    for (i in src.size - 1 downTo 0) {
        val number = src[i]
        var step = 0
        while (!stack.isEmpty() && (stack.peek() <= number)) {
            step++
            stack.pop()
        }
        ret[i] = if (stack.empty()) -1 else step
        stack.push(number)
    }

    println(ret.asList())
}

fun main() {
    nextGreater(arrayOf(2, 1, 2, 4, 3))
    nextWarmer(arrayOf(21, 24, 23, 22, 18, 24, 30, 28))
}