package cn.song.dbmap

import kotlin.jvm.internal.markers.KMutableMap

/**
 * Created by hzsongzhengwang on 2015/12/21.
 */

var aMap = mapOf<String, Int>("a" to 10, "b" to 13)

fun testEntryDefaultValue(key : String){
    var next = 1 + aMap.getOrElse(key) {0}
    aMap += key to next
}

fun showMap(){
    for( (key, value) in aMap){
        println("$key -- $value")
    }
}

fun main(args: Array<String>) {
    testEntryDefaultValue("a")
    showMap()  //=> a--11 , b--13

    testEntryDefaultValue("c")
    showMap()  //=> a--11, b--13, c--1


    val raw = mapOf(Pair("a", "aa"), Pair("b", "bb"), Pair("c", "cc"), "a" to "23")
    var oldKey = ""
    val result = raw.flatMap {
        val ret = arrayListOf<Any>()
        if(it.key != oldKey){
            ret.add(it.key)
            ret.add(it.value)
            oldKey = it.key
        } else{
            ret.add(it.value)
        }
        ret
    }
    println(result)

}