package ca.six.kex.delegate

import kotlin.properties.Delegates

val lazyValue: String by lazy{
    println("computed")
    "lazy value name"
}

// getter没有observe的必要. 所以这里只涉及到setter
var id : String by Delegates.observable("initialValue") { property, oldValue, newValue ->
    println("$property : $oldValue --> $newValue")
}


fun main(args: Array<String>) {
    println(lazyValue)   //=> computed;  lazy value name
    println(lazyValue)   //=> lazy value name

    id = "97"  //=> property id (Kotlin reflection is not available) : initialValue --> 97
    id = "be"  //=> property id (Kotlin reflection is not available) : 97 --> be
}