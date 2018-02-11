package ca.six.kex

fun main(args: Array<String>) {
    val sp = Sp()
    sp.does {
        save("key", "test")
    }
    println("szw ${sp.get("key")}")
}