package ca.six.algo

fun f(n: Int):Int {
    return n
}

fun main() {
    val start = System.currentTimeMillis()
    println(f(100))
    val end = System.currentTimeMillis()
    println("cost time2 = ${(end - start) / 1000f}")
}