package ca.six.klplay.advanced.function

fun foo2(a: Int): Int {
    return 23 + a
}

fun bar2(a: Int, body: (Int) -> Int): Int {
    return body(a)
}

fun main(args: Array<String>) {
    val ret3 = bar2(10, ::foo2)
    println(ret3) //=> 33
}