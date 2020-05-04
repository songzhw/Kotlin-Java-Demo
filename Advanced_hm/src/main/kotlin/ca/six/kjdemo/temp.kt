package ca.six.kjdemo

fun main() {
    // 默认是1到10(包含10), step 3是步长为3
    for (i in 1..10 step 3) {
        println(i) //=> 1 4 7 10
    }
}