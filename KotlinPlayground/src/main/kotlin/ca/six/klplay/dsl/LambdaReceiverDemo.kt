package ca.six.klplay.dsl

fun main(args: Array<String>) {
    val square = fun Int.(): Int = this * this
    val sum = fun Int.(num1: Int, num2: Int) = this + num1 + num2

    println(3.square())    //=> 9
    println(3.sum(2, 3))  //=> 8
}