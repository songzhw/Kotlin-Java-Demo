package ca.six.klplay.advanced.operator


data class Point(val x: Int, val y: Int) {
    operator fun plus(other : Point) : Point {
        return Point(x + other.x, y + other.y)
    }
}
 //用data关键字, 就有toString的写法帮我们写好了

// ============= Unary Prefix Operators =============
operator fun Point.unaryMinus() = Point(-x, -y)

operator fun Point.unaryPlus() = Point(x + 1, y + 1)

operator fun Point.not() = Point(0, 0);

// ============= inc and dec =============
operator fun Point.inc() = Point(x + 1, y + 1)
operator fun Point.dec() = Point(x - 1, y - 1)


fun main(args: Array<String>) {
    var point = Point(10, 20)
    println("szw ${-point}")   //=> Point(-10, -20)
    println("szw ${+point}")   //=> Point(11, 21)
    println("szw ${!point}\n")   //=> Point(0, 0)

    // ++a, --a是先计算好了结果并赋值给a, 再返回a的新值做为表达式${++point}的结果.
    println("szw ${++point}")   //=> Point(11, 21).
    println("szw point = $point")  //=> Point(11, 21).
    println("szw ${--point}")   //=> Point(10, 20). 即从新Point(11,21)中各减去1
    println("szw point = $point\n") //=> Point(10, 20)


    println("szw ${point++}")   //=> Point(10, 20)
    println("szw point = $point")  //=> Point(11, 21).
    println("szw ${point--}")   //=> Point(11, 21)
    println("szw point = $point\n")  //=> Point(10, 20).


    println("szw p1 + p2 = "+ (Point(10, 20) + Point(20, 30))) //=> Point(30, 50)

}
