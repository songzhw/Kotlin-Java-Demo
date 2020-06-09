package ca.six.algo.recurse

fun fibonacci(n: Int): Int {
    println(n)
    if (n == 0) return 0
    if (n == 1) return 1
    else return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
//    println("fibonnaci : ${fibonacci(4)}")
//    println("fibonnaci : ${fibonacci(5)}")
    println("fibonnaci : ${fibonacci(66666)}")
}