package ca.six.knew.k_1_1

import ca.six.jold.C5
import java.util.*

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

// 6. 数字字面值, 也能有分隔 (也能适应中国的万字间隔)
fun bigNumber() {
    val oneMillion = 1_000_000
    val oneMillionInChinese = 100_0000
    println(" $oneMillion \n $oneMillionInChinese")

    val hex = 0xFF_1e1e1e  //备注: 0x_FF_1e1e1e可不行
    val bytes = 0b1101_1101_0011

    val hexColor : Int = 0xFF_1e1e1e.toInt()
}

// 7. 局部变量也可以委托了
fun needAnwer() = Random().nextBoolean()

fun localDelegate() {
    val answer by lazy {
        println("Calculating the answer...")
        42
    }
    if (needAnwer()) {
        println("The answer is $answer")  //=> 42 (有"calculating the an=swer..."打印出来)
        println("answer again : $answer") //=> 42 (没有"calculating the an=swer..."打印出来)
    } else {
        println("I don't know neither")
    }
}

// 8. 泛型能用于Enum了
enum class RGB { RED, GREEN, BLUE }

enum class ARGB { ALPHA, RED, GREEN, BLUE }

inline fun <reified T : Enum<T>> printEnumValues() {
    val result = enumValues<T>().joinToString { it.name }
    println(result)
}

fun T_Enum() {
    printEnumValues<RGB>() //=> RED, GREEN, BLUE
    printEnumValues<ARGB>() //=> ALPHA, RED, GREEN, BLUE
}

// 9. 弃用mod, 改用rem
fun remDemo() {
    println(4.mod(3)) //=> 1
    println(5.rem(3)) //=> 2
}

// 10. String与数字的转换
fun siConv() {
    val port = System.getenv("PORT")?.toIntOrNull() ?: 80
    println("port = $port")  //=> 80
}

// 11. onEach()
fun onEachDemo() {
    val list = listOf<Int>(11, 14, 12, 22, 21, 10)
    list.filter { it > 11 }
            .onEach { println("start working on $it") }
            .forEach {
                Thread.sleep(1000)
                println("done with $it")
            }
}

// 12. takeIf(), takeUnless()
fun takeDemo() {
    val result = "".takeUnless(String::isEmpty)
    println("takeUnless : $result")  //=> null

    inString("in") //=> 3
    inString("sb") //=> crash: java.lang.IllegalStateException: keyword not found
}

fun inString(keyword: String) {
    val index = "string".indexOf(keyword)
            .takeIf { it >= 0 }
            ?: error("keyword not found")
    println("takeDemo $index")
}

// 13. groupBy()
fun streamDemo() {
    val list = listOf<Int>(1, 3, 2, 8, 4, 7, 6)
    val groupedBy = list.groupBy { it % 3 }
            .mapValues { (key, sublist) -> println("$key, $sublist") }
    /* =>
        1, [1, 4, 7]
        0, [3, 6]
        2, [2, 8]
     */
    println("groupBy = $groupedBy")  //=> groupBy = {1=kotlin.Unit, 0=kotlin.Unit, 2=kotlin.Unit}
}

// 14. list的实例化更灵活了
fun initList() {
    val squares = List(4) { idx -> idx * idx }
    val mutable = MutableList(4) { 0 }
    println("$squares")   //=> [0, 1, 4, 9]
    println("==================")
    println("$mutable")   //=> [0, 0, 0, 0]


    // Map的初始化也能有withDeafult. 但只能用getValue()来提取
    val map = mapOf<String, Int>()
    val map2 = map.withDefault { k -> k.length}
    println("${map["bing"]}")  //=> null
    println("${map2["szw"]}")  //=> null
    // println("${map.getValue("bing")}")  //=> crash : java.util.NoSuchElementException: Key bing is missing in the map.
    println("${map2.getValue("xxx")}")  //=> 3
    println("${map2["xxx"]}")  //=> null (getValue()后, 用切片符仍是null
}


// *. 委托属性绑定的拦截

fun main(args: Array<String>) {
    initList()
}