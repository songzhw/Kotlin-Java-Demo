package cn.song.acfunction

/**
 * Created by hzsongzhengwang on 2015/8/17.
 */

fun double(x: Int): Int {
    return x*2;
}

// default arguments
fun readByte(b:Array<Byte>,  off : Int = 0 , len : Int = b.size() ){
    // ...
}

fun triple(x:Int) = x * 3

//fun main(args: Array<String>) {
//    var byte
//    readByte(byte)  // Default Arguments
//    readByte(byte, len=23) // Named Arguments
//}

