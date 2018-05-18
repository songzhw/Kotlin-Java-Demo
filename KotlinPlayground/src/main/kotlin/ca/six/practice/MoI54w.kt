package ca.six.practice

import java.net.URL

fun urlAndString(){
    val url = URL("https://github.com/abc/a/issues/12")
    println("host = ${url.host}, path = ${url.path}")  //=> host = github.com, path = /abc/a/issues/12

    val query = "github.com google test"
    val querys = query.split(" ")
    querys.forEach { println(it) }

}

fun main(args: Array<String>) {
    urlAndString()
}