// 设计一个有min()找出最小值的栈. 要求push, pop, min均为O(1)

package algorithm.stack

import java.util.*

fun stackSample() {
    val stack = Stack<Int>()
    stack.push(2)
    stack.push(1)
    stack.push(5) //=> 2, 1, 5
    stack.pop() //=> 2, 1
    println(stack)
}

fun wrong() {
    var minValue = -1
    // push()时更新minValue
    // 但pop()时又得再找min(), 这就不是O(1)了
}

class MinInStack : Stack<Int>() {
    val stackStoringMin = Stack<Int>()
    var minValue: Int = Int.MAX_VALUE

    override fun push(item: Int): Int {
        if (item <= minValue) {
            stackStoringMin.push(item)
            minValue = item
        }
        return super.push(item)
    }

    override fun pop(): Int {
        val value1 = super.pop()
        if (value1 == stackStoringMin.peek()) {
            stackStoringMin.pop()
        }
        return super.pop()
    }

    fun min(): Int {
        // to avoid "java.util.EmptyStackException"
        if (stackStoringMin.isEmpty()) {
            return Int.MAX_VALUE
        }
        return stackStoringMin.peek();
    }

    override fun toString(): String {
        val s1 = super.toString()
        val s2 = stackStoringMin.toString();
        return "s1 = $s1, s2 = $s2"
    }
}


fun main() {
    val s = MinInStack()
    s.push(3)
    s.push(5)
    s.push(4)
    s.push(2)
    println(s)
    println("min = ${s.min()}")
    println("============ (after pop() )")

    s.pop()
    println(s)
    println("min = ${s.min()}")
}

