fun main() {
    val key = "rx.error"
    callJs(key, "en_US")
    callJs(key, """
        "en_US"
""".trimIndent())
}

fun callJs(key: String, value: String){
    val payload = if (value.isEmpty()) """{"action": "$key"}""" else """{"action":"$key","params":$value}"""
    val jsFunc = "window.processInjectedData('$payload')"
    println(jsFunc)
}