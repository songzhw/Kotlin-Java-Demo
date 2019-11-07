fun main() {
    val header = mapOf<String, String>()
    val mine = header.toMutableMap()
    mine.put("if-none-match", "1")
    foo(mine)
    println(mine)
}

fun foo(header: MutableMap<String, String>?) {
    header?.put("if-none-match", "2")
}