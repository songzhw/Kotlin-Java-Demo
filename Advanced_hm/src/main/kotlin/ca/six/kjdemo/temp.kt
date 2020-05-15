package ca.six.kjdemo


class Item

fun main() {
    val map1 = mapOf(String::class.java to "first", Int::class.java to "second")
    // foo(map1) // => Error

    val map2 = mapOf(String::class.java to "first", Item::class.java to "second")
    foo(map2)

    val map3: Map<Class<out Any>, String> = mapOf(String::class.java to "first", Int::class.java to "second")
    foo(map3)
}


fun foo(map: Map<Class<out Any>, String>) {

}