import java.util.*

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

fun getParameterNameJava8(clazz: Class<*>, methodName: String): List<String> {
    val paramterList: MutableList<String> = ArrayList()
    val methods = clazz.declaredMethods
    for (method in methods) {
        if (methodName == method.name) {
            val params = method.parameters
            for (parameter in params) {
                paramterList.add(parameter.name)
            }
        }
    }
    return paramterList
}

class Test {
    fun test(id: Int, name: String) {}
}

fun main() {
    log("szw", "one", "two")

    val args = getParameterNameJava8(Test::class.java, "test")
    for (arg in args) {
        println(arg)
    } //=> arg0, arg1
}