package ca.six.knew.k_1_1

import ca.six.jold.C5

// 1. Coroutine  (实验性的. 正式商用代码不建议使用)

// 2. 类型别名 (类似C中的typedef)
class UrlItem(val host: String, val path: String) {}
typealias UrlDetail = HashMap<String, UrlItem>

fun canISeeYoutube(urls: UrlDetail) = urls.containsKey("youtube")

// 3. 密封类在Kotlin 1.0中的各种限制都没了. 可以同一个文件中任何地方定义一个seal类的子类


// 4. lambda可用解构声明了 (Destructuring Declarations)
fun destructDeclareInLambda() {
    val map4 = mapOf<Int, String>(1 to "one", 2 to "two")
    map4.mapValues { (key, value) ->
        println("$key - $value")
    }

}

// 5.  lambda中, 用"_"代表未使用的参数
fun lambda_() {
    val obj = C5()  // SAM Convertion
    obj.setOnChangeListener { _, _, action ->
        println(action)
    }
    obj.change()
}

fun main(args: Array<String>) {
}