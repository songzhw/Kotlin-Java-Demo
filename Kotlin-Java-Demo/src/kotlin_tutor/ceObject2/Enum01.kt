package cn.song.ceObject2

/**
 * Created by hzsongzhengwang on 2015/9/17.
 */
enum class Color(var rgb: Int){
    RED(0xff0000),
    GREEN(0x00ff00)
}


fun testE(args: Array<String>) {
    var colorPress = Color.RED
    println(colorPress)

//    val colorUnknow = Color(0xcccccc) // error : Enum types cannot be instantiated
//    println(colorUnknow)

}
