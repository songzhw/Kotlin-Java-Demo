package cn.song.stream

import kotlin_tutor.stream.Biz

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
/*
szw KEVIN
szw KINGSLY
szw KOBE
 */

fun testGroupBy(){
    println("=====================================")

    val bizList = arrayListOf(Biz("a",arrayListOf("food")),
            Biz("bb",arrayListOf("music")),
            Biz("ccc",arrayListOf("food","yoga")),
            Biz("dddd", arrayListOf()))
    var oldKey = ""
    val result = bizList.groupBy {
        val list = it.category
        if(list != null && list.size > 0){
            list.get(0)
        } else {
            "NoCategory"
        }
    }.flatMap {
        val ret = arrayListOf<Any>()
        if(it.key != oldKey){
            ret.add(it.key)
            oldKey = it.key
        }

        for(item in it.value){
            ret.add(item)
        }

        ret
    }


    println(result.size)
    for(value in result){
        println(value)
    }

}

fun main(args: Array<String>) {
    testStream()
    testGroupBy()
}

