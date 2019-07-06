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


fun main() {

}