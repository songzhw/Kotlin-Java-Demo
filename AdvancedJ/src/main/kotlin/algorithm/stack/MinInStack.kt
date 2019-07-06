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

fun wrong(){
    var minValue = -1
    // push()时更新minValue
    // 但pop()时又得再找min(), 这就不是O(1)了
}

fun main() {

}