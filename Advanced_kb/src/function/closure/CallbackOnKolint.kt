package function.closure

fun main() {
    val javaObj = CallbackOnJava()
    javaObj.call("hello") { name ->
        20
    }
}