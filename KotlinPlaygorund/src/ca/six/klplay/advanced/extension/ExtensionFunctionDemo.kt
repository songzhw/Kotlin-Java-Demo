package ca.six.klplay.advanced.extension

fun String.first(num: Int): String {
    return this.substring(0, num);
}

fun main(args: Array<String>) {
    println("test".first(2))
}




