package ca.six.kjdemo.io

import java.util.*

fun main() {
    val str = "Hello world, this is word;apple;";
    val scanner = Scanner(str);
    println("01: ${scanner.findWithinHorizon("w.*d", 5)}") //=> null
    println("02: ${scanner.findWithinHorizon("w.*d", 15)}") //=> world
    println("03: ${scanner.findWithinHorizon("w.*d", 25)}") //=> word
    println("04: ${scanner.nextLine()}") //=> ;apple;  (这一点不太明白, 为什么nextLine()是最后一部分)
}