package cn.song.agdelegate


/**
songzhw - 2015/8/16
Copyright 2015 Six.
 */

/**
 * Properties stored in a map. This comes up a lot in applications like parsing JSON
 * or doing other "dynamic" stuff. Delegates take values from this map (by the string keys -
 * names of properties). Of course, you can have var's as well (with mapVar() function),
 * that will modify the map upon assignment (note that you'd need MutableMap instead of read-only Map).
 */
import kotlin.properties.Delegates

class User1(val map: Map<String, Any?>) {
    val name: String by Delegates.mapVal(map)
    val age: Int     by Delegates.mapVal(map)
}

//fun main(args: Array<String>) {
//    val user = User1(mapOf(
//            "name" to "John Doe",
//            "age"  to 25
//    ))
//
//    println("name = ${user.name}, age = ${user.age}")
//    //=> name = John Doe, age = 25
//}