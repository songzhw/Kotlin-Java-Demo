package cn.song.abbasic

/**
 * Created by hzsongzhengwang on 2015/8/21.
 */
fun cast(args: Array<String>) {

    // 1. "is" and "!is"
    var x : Any = 23
    if(x is String) {println("String")}
    if(x !is Int) {println("is not Int")}

    when(x){
        is Int -> println(x+1)
        is String -> print(x.length + 1)
        0,1 -> println("x == 0 or x == 1")
        x.hashCode() % 2 == 0 -> println("even hashcode")
        in 2..10 -> println("x [2,10]")
        else -> println("otherwise")
    }


}

fun cast2( x : Any){
    // 2. "as" and "as?"

    /*
    val x2: String = x as String  // the cast operator throws an exception if the cast is not possible.
    */

    val x3: String? = x as? String //one can use a safe cast operator as? that returns null on failure

    println("x3 = $x3") //=> 23, null

}

fun main(args: Array<String>) {
    cast2("22")
    cast2(24)
}