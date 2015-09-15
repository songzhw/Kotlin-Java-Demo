package cn.song.ccBuilder

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */

// because html() return a Html, so the result of result() is a Html object
fun result() =
        html{
            head {
            }
        }


fun main(args: Array<String>) {
    println(result())
}