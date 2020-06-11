package ca.six.algo

fun maxNDigit01(n: Int){
    val max = Math.pow(10.0, n.toDouble())
    println(max-1)
}

fun main() {
    maxNDigit01(3)
}
