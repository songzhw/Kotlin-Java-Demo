package ca.six.algo

fun power(base: Double, exponent: Int) {
    var ret = base
    for (i in 2..exponent) {
        ret *= base
    }
    println("power($base, $exponent) = $ret")
}

fun main() {
    power(3.0, 3) //=> 27
    power(2.0, 4) //=> 16
}