package ca.six.practice

import java.net.URL

fun urlAndString() {
    val url = URL("https://github.com/abc/a/issues/12")
    println("host = ${url.host}, path = ${url.path}")  //=> host = github.com, path = /abc/a/issues/12

    val query = "github.com google test"
    val querys = query.split(" ")
    querys.forEach { println(it) }

}

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


fun main(args: Array<String>) {
    urlAndString()
}