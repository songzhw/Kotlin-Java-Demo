fun foo(a: Int): Int {
    return 23 + a
}

fun bar(a: Int, body: (Int) -> Int): Int {
    return body(a)
}

fun main(args: Array<String>) {
    // 函数的调用, 参数不能省(). -- 跟ruby不一样
//    val ret = foo 23
//    println ret

    val ret1 = foo(23)
    println(ret1)

    val ret2 = bar(10) {
        it * 3
    }
    println(ret2) //=> 30

}