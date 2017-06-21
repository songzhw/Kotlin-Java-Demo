package cn.song.ceObject2

/**
 * Created by hzsongzhengwang on 2015/9/17.
 */
class Outer{
    private var bar : Int = 11
    var id = 12

    inner class Nested{
        fun foo() = 2+id
        fun bing() = 2+bar
        fun yun(){
            bar = 23
            id = 100
        }
    }
}


fun testI(args: Array<String>) {
    println("result = ${Outer().Nested().foo()}") //=> 14
    println("result = ${Outer().Nested().bing()}") //=> 13

    var obj = Outer()
    println("001 "+obj.Nested().foo()) //=> 14
    println("002 "+obj.Nested().bing()) //=> 13
    println("003 "+obj.Nested().yun())  //=> Unit
    println("004 "+obj.id) //=> 100

}
