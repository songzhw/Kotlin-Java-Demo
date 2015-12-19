package cn.song.stream

/**
 * Created by hzsongzhengwang on 2015/12/19.
 */

fun testStream() {
    var names = arrayListOf("song","kevin","jorden","kobe","kingsly","yao")

    names.filter { it.startsWith("k") }
        .sortedBy { it }
        .map{ it.toUpperCase()}
        .forEach {
            println("szw $it")
        }
}

fun main(args: Array<String>) {
    testStream();
}

/*

szw KEVIN
szw KINGSLY
szw KOBE

 */