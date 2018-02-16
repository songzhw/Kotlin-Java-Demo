package ca.six.kex

fun main(args: Array<String>) {
    val sp = Sp()
    sp.does {
        save("key", "test") // save()是Sp中的方法
    }
    println("szw ${sp.get("key")}")
}