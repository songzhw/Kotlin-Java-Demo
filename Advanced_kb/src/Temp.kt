import java.lang.StringBuilder

fun log(prefix: String, vararg args: Any) {
    val sb = StringBuilder(prefix)
    sb.append(": ")
    for (param in args) {
        sb.append(param)
        sb.append(", ")
    }
    sb.removeSuffix(",")
    println(sb.toString())
}

fun main() {
    log("szw", "one", "two")
}