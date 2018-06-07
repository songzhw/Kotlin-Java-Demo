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
    println("($id, $names, ${names.size}, ${names::class.java.simpleName})")
    names.forEach { println(it) }
}

fun main(args: Array<String>) {
    val ary = arrayOf("2", "a")
    foo3(23, "1", *ary, "b", "c") //=> (23, [Ljava.lang.String;@4617c264, 5, String[])

    println("=======")
    foo3(21) //=> (21, [Ljava.lang.String;@36baf30c, 0, String[])
}

// 所以坑在这里: 虽然参数为空, 但这里的varargs仍不是空的. 这在反射时特别要注意, 这vararg得有一个空的array在才行