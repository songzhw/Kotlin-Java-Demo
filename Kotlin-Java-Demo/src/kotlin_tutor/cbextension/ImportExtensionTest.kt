package cn.song.cbextension

// Note: This must have this import code !!!
import cn.song.caextension.swap2

/**
 * Created by hzsongzhengwang on 2015/9/10.
 */

fun testImportExtension(){
    var ary = intArrayOf(11, 14, 15,28)
    ary.swap2(1,3)
    ary.forEach { println(it) }
}

fun main(args: Array<String>) {
    testImportExtension()

}