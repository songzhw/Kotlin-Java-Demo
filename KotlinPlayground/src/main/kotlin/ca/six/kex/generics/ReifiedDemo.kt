package ca.six.kex.generics

// 普通的泛型
fun <T> fromJson(json: String, clz: Class<T>) {
//    println("class01 = ${T::class.java}")  // Error!
}

// 带reified的泛型 (间接帮助我们拿到了T.class)
inline fun <reified T> fromJson(json: String){
    val clz = T::class.java
    println("class = $clz")   //=> class = class ca.six.kex.generics.Person
    fromJson(json, T::class.java)
}

class Person(var id: Int, var name: String)

fun test(){
    fromJson<Person>("""{"id": 0, "name": "Jack" }""")
}

fun main(args: Array<String>) {
    test()
}