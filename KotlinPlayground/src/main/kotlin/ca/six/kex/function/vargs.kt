package ca.six.kex.function

/* // Error
fun foo3(vararg names: String, id : Int){
    names.forEach { println(it) }
}

fun main(args: Array<String>) {
    foo3(*arrayOf("1","b","c"), 23)
}
*/

fun foo3(id: Int, vararg names: String) {
    names.forEach { println(it) }
}

fun main(args: Array<String>) {
    val ary = arrayOf("2", "a")
    foo3(23, "1", *ary, "b", "c")
}