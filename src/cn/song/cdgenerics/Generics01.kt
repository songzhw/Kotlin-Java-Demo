package cn.song.cdgenerics

/**
 * Created by hzsongzhengwang on 2015/9/14.
 */

// unlike Java, arrays in kotlin are invariant.
// This means that kotlin does not let us assign an Array<String> to an Array<Any>

// But you can use Array<out Any>.  See Kotlin-docs "Generics -- Type Projections"

class Box<T>(t:T){
    var value = t
}

fun generics01() {
    val box0 = Box<Int>(12)
    val box1 = Box(13) // okay, too. Compiler can infer 12 is int, so we are talking about Box<Int>
    println(box1.value)  //=> 13
}

// why "kotlin does not let us assign an Array<String> to an Array<Any>"?
// because:
//      var list = Array<String>
//      var objs : Array<Any> = list;
//      objs.add(1) // since the generics type is Any, so this is okay.
                    // however, it's actually Array<string>.add(1),
                    // so , this is wrong, and is prohibits by Kotlin


// by the way, the java has its way : WildType
//      list = Array<String>
//      objs = Array<? extends Object>
//      objs = list; //这保证了objs里取出来的一定是Objects
//
// in java, Array<String> is not a subclass of Array<Object>
// however, Array< ? extends Object> is a subclass of Array<Object>
