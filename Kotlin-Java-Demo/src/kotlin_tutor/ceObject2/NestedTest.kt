package cn.song.ceObject2

/**
 * Created by hzsongzhengwang on 2015/9/17.
 */

class Outer1{
    private val bar : Int = 11
    val id = 12

    class Nested{
        fun foo() = 2
    }
}


fun testNested(args: Array<String>) {
    println("result = ${Outer1.Nested().foo()}") //=> result = 2
}


