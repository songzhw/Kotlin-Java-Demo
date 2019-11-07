fun main() {
    val header = mapOf<String, String>()
    header.put("if-none-match", "1")
    foo(header)
    println(header)
}

fun foo(header: MutableMap<String, String>?) {
    header?.put("if-none-match", "2")
}