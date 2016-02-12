package cn.song.ceObject2

/**
 * Created by hzsongzhengwang on 2015/9/18.
 */

// 不想太复杂的定义类，所以可以用ObjectExpression。 有点类似Java里的匿名内部类

fun testOE(){
    val adHoc = object {
        var x : Int = 10
        var y : Int = 5
    }
    println(adHoc.x + adHoc.y) //=> 15
}
