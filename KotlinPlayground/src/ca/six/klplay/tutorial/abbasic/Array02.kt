package cn.song.abbasic

/**
 * Created by hzsongzhengwang on 2015/8/18.
 */

fun array2(args: Array<String>) {

    val ary1 = arrayOf(1,2,3,"4")
    ary1.forEach{ println(it)} //=> 1,2,3,4
    //    ary1.forEach { println(it+1) }  // error!

    // error 1: Kotlin语法不支持这样的赋值
//    var ary0 = []

    //error 2:
//    val ary0 = arrayOfNulls(3) // error. Need to know which type is null

    // 之所以声明类型，是因为arrayOfNulls要求指定数组存储的数据类型
    val ary2 : Array<Int?> = arrayOfNulls(5)
    ary2[2] = 23  //后期才给赋值

    var ary3  = Array(5, {(it * it ).toString()})  //=> 0 1 4 9 16

    var ary4 = intArrayOf(1,2,3)   // int array
    var ary5 = arrayListOf("1","2", "3")  // string array


}