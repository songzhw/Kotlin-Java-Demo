package cn.song.abbasic

/**
 * Created by hzsongzhengwang on 2015/8/21.
 */
//fun cast(args: Array<String>) {
//
//    // 1. "is" and "!is"
//    var x : Any = 23
//    if(x is String) {println("String")}
//    if(x !is Int) {println("is not Int")}
//
//    when(x){
//        is Int -> println(x+1)
//        is String -> print(x.length() + 1)
//        is Array<Int> -> println(x.sum())
//    }
//
//    // 2. "as" and "as?"
//    val x2: String = x as String  // the cast operator throws an exception if the cast is not possible.
//    val x3: String? = x as? String //one can use a safe cast operator as? that returns null on failure
//
//}