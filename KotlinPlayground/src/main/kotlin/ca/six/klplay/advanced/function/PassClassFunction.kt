package ca.six.klplay.advanced.function

fun foo3(a: Int): Int {
    return 23 + a
}

fun bar3(a: Int, body: (Int) -> Int): Int {
    return body(a)
}

class PassFuncClass {
    fun foo_c(a: Int): Int {
        return 23 + a
    }

    fun bar_c(a: Int, b: (Int) -> Int): Int {
        return b(a)
    }

    fun bar_c2(a: Int, b: PassFuncClass.(Int) -> Int): Int {
        return b(a)
    }
}

fun main(args: Array<String>) {
    val ret1 = bar3(10, ::foo2)
    println(ret1) //=> 33

    val obj = PassFuncClass()

    // 说明bar3()中定义的参数(Int)->Int, 适用于类的方法, 也适用于顶级方法
    println(" ${bar3(10, obj::foo_c)} ") //=> 33
    println("${obj.bar_c(11, obj::foo_c)}") //=> 34
    println("${obj.bar_c(12, ::foo3)}") //=> 35

//    println("${obj.bar_c2(13, ::foo3)}")  // ERROR
//    println("${obj.bar_c2(14, obj::foo_c)}")  // ERROR

    val ret5 = obj.bar_c2(15) {
        foo_c(it)
    }

}