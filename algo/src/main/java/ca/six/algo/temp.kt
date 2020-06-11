package ca.six.algo

fun maxNDigit01(n: Int) {
    val max = Math.pow(10.0, n.toDouble())
    println(max - 1)
}

fun maxNDigit02(n: Int) {
    var max = 10
    for (i in 2..n) {
        max *= 10
    }
    println(max - 1)
}

fun maxNDigit(n: Int) {
    val sb = StringBuilder()
    for (i in 1..n) {
        sb.append("9")
    }
    println(sb)
}

fun main() {
    maxNDigit(3)
}
