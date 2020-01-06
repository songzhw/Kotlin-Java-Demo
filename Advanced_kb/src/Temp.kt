interface IWork {
    fun minus(s1: String, s2: String): String
}

fun main() {
    val s1 = "helloworld"
    val s2 = "hello"

    val minus: (String, String) -> String = { s1, s2 -> s1.replace(s2, "") }

    println(minus(s1, s2))          //=> world
    println(minus.invoke(s1, s2))   //=> world

    fun did(in1: IWork, s1: String, s2: String) {
        in1.minus(s1, s2)
    }
    // did(minus, s1, s2) // ERROR

}