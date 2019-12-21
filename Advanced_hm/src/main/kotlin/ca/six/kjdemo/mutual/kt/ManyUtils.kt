package ca.six.kjdemo.mutual.kt

fun String.firstOne(): String {
    return this.substring(0, 1)
}

fun Int.dollar(): String {
    return "\$$this"
}

fun main() {
    val num = 10
    println("szw $$num")  //=> szw $10
    println("szw \$$num") //=> szw $10
}