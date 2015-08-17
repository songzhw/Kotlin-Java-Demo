package cn.song.acfunction



/**
 * Created by hzsongzhengwang on 2015/8/17.
 */


fun main(args: Array<String>) {
    val asc = Array(5, {i -> (i * i).toString()})
    println(asc) //=> ["0", "1", "4", "9", "16"]

    val strings = arrayListOf("a","ef","abc","czxy")
    var resultArray = strings.filter{it.length() >= 2}
        .sortBy{it}
        .map{it.toUpperCase()}
    for(a in resultArray ){
        println(a)  //=> ABC, CZXY, EF
    }

    var ints = intArrayOf(12,18, -20)
    var sum = 0
    ints.filter { it > 0 }
        .forEach { sum += it }
    println("sum = ${sum}")//=> 30

}