package ca.six.kjdemo

import kotlin.math.sign

fun main() {
    println(100.1f.sign.toInt()) //=> 1
    println(-99.2f.sign.toInt()) //=> -1
}