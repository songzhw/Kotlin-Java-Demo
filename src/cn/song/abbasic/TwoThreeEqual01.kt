package cn.song.abbasic

/**
 * Created by hzsongzhengwang on 2015/8/18.
 */


//On the Java platform, numbers are physically stored as JVM primitive types,
//unless we need a nullable number reference (e.g. Int?) or generics are involved.
//In the latter cases numbers are boxed.

//fun main(args: Array<String>) {
//    //Note that boxing of numbers does not preserve identity:
//    val a: Int = 10000
//    val b: Int = a
//    println(b === a) // Prints 'true'
//    val boxedA: Int? = a
//    val anotherBoxedA: Int? = a
//    println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
//
//    //On the other hand, it preserves equality:
//    val a2: Int = 10000
//    val b2: Int = a2
//    println(a2 == a2) // Prints 'true'
//    val boxedA2: Int? = a2
//    val anotherBoxedA2: Int? = a2
//    println(boxedA2 == anotherBoxedA2) // Prints 'true'
//}

// note that the difference of the two above code is == and ===