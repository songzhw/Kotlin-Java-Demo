package ca.six.klplay.advanced.operator

data class Point(val x : Int, val y : Int) {
}

operator fun Point.unaryMinus() = Point(-x, -y)

fun main(args: Array<String>) {
    val point = Point(10, 20)
    println("szw ${-point}")
}
