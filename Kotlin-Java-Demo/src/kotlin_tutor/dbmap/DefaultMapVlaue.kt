package cn.song.dbmap

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

fun mainShow(args: Array<String>) {
    testEntryDefaultValue("a")
    showMap()  //=> a--11 , b--13

    testEntryDefaultValue("c")
    showMap()  //=> a--11, b--13, c--1
}