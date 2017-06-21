package cn.song.cdgenerics

/**
 * Created by hzsongzhengwang on 2015/9/14.
 */

// Java Generics has wildcard types(通配符), and Kotlin doesn't have any.
//    (like :"ArrayList<? extends Foo>")
// Kotlin has two other things: declaration-site variance , type projections.


// [Kotlin]  Declaration-site Variance (变化，不一致；  方差)

/*
// ERROR !!

abstract class Source<T>{
    abstract fun nextT() : T
}

fun demo(strs : Source<String>){
    val objs : Source<Any> = strs
}

*/


// correct
abstract class Source<out T>{
    abstract fun nextT() : T
}

fun demo(strs : Source<String>){
    val objs : Source<Any> = strs
    println(objs.nextT())
}

