package ca.six.practice

import java.net.URL

// =============================================

fun urlAndString() {
    val url = URL("https://github.com/abc/a/issues/12")
    println("host = ${url.host}, path = ${url.path}")  //=> host = github.com, path = /abc/a/issues/12

    val query = "github.com google test"
    val querys = query.split(" ")
    querys.forEach { println(it) }

}

// =============================================

fun jumpOutofOneLoop() {
    // 跳出内层循环. 3-4后是4-1, 打到4-4, 接着是5-1, ..., 一直到10-3, 10-4
    for (i in 1..10) {
        for (j in 1..10) {
            println("$i, $j")
            if (i > 2 && j > 3) break
        }
    }
}

fun jumpOutOfTwoLoops() {
    //打印完1,2后, 打印3-1, 3-2, 3-3, 3-4, 就完了
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            println("$i, $j")
            if (i > 2 && j > 3) break@loop
        }
    }
}

fun error_jumpOutOfTwoLoops() {
    /* 编译会失败: Back-end (JVM) Internal error:
    Couldn't inline method call 'forEach' into local final func <anonymous> ..
     */

    /*
    val ary1 = arrayOf(1, 2, 3, 4)
    val ary2 = arrayOf(1, 2, 3)
    ary1.forEach { n1 ->
        inner@ ary2.forEach { n2 ->
            println("$n1, $n2")
            if(n1 > 2 && n2 > 1) {
                return@inner
            }
        }
    }
    */

}

// 1-11, 1-12, 1-13
// 2-11, 2-12, 2-13
// 3-11, 3-12
// 4-11, 4-12
fun success_jumpOutOfInnerLoop() {
    val num1 = listOf(1, 2, 3, 4)
    val num2 = listOf(11, 12, 13)
    num1.forEach inner@ { n1 ->
        num2.forEach { n2 ->
            println("$n1, $n2")
            if (n1 > 2 && n2 > 11) {
                return@inner  //不能在这用break, continue. 但这个效果等同于continue
            }
        }
    }
}

// =============================================
data class A(val id: Int, val time: Long) {
}

fun listStream() {
    val rawList: List<A> = arrayListOf<A>(A(11, 20), A(23, 20), A(11, 23), A(17, 24))
    rawList
            .sortedWith(Comparator<A> { a1, a2 ->
                a2.id.compareTo(a1.id)
            })
            .take(3)
            .forEach { A ->
                println("$A")
            }
}

// =============================================

fun main(args: Array<String>) {
    urlAndString()
//    jumpOutOfTwoLoops()
//    success_jumpOutOfInnerLoop()
    listStream()
}