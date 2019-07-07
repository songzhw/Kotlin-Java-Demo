fun is2Power(n: Int) {
    if (n and n - 1 == 0) {
        println("if")
    }
}

fun main() {
    println(32 shl 2) //=> 128

    println(32 shr 2) //=> 8
    println(32.ushr(2))//=> 8

    // >>> 无符号右移
    println(-32 shr 2) //=> -8
    println((-32).ushr(2))//=> 1073741816

}