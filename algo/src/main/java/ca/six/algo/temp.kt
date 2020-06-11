package ca.six.algo

fun power(base: Double, exponent: Int) {
    if(exponent < 0) {
        println("exponent can't be negative")
        return
    }

    var ret = base.toLong()
    for (i in 2..exponent) {
        ret *= base.toLong()
    }
    println("power($base, $exponent) = $ret")
}

fun main() {
    // 1. 功能性测试
    power(3.0, 3)  //=> 27
    power(2.0, 4)  //=> 16

    // 2. 边界测试
    power(3.0, 1)  //=> 3
    power(3.0, -2) //=> exponent can't be negative

    // 3. 性能测试
    power(3.0, 1000) //=> 6203307696791771937
}