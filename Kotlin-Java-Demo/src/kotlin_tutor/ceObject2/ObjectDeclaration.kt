package cn.song.ceObject2

/**
 * Created by hzsongzhengwang on 2015/9/18.
 */

// how to do a singleton class  -- object declaration.

object Singleton{
    fun foo() =  2
}

fun testOD(args: Array<String>) {
    var a = Singleton //note : it is not "var a = Singleton()"
}


// NOTE: object declarations can't be local (i.e. be nested in directly inside a function),
// but they can be nested into other object declarations or non-inner classes.