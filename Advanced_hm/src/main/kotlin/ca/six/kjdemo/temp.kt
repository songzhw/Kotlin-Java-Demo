package ca.six.kjdemo


fun foo(): String {
    val ary = arrayOf(1, 3, 5, 2, 9)

    var ret = 0
    for (num in ary) {
        ret = num
        if (ret % 2 == 0) break;
    }

    return "$ret"
}

fun main() {
    val ret = foo()
    print(ret) //=> 2
}