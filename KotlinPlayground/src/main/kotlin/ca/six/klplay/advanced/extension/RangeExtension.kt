package ca.six.klplay.advanced.extension

fun main(args: Array<String>) {
    (0..10 step 2).forEach{ i ->
        println("i = $i")
    } //=> 0, 2, 4, 6, 8, 10
}