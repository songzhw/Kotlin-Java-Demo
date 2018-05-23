package ca.six.kex.generics

// 普通的泛型
fun <T> fromJson(json: String, clz: Class<T>) {
}

// 带reified的泛型 (间接帮助我们拿到了T.class)
inline fun <reified T> fromJson(json: String){
    fromJson(json, T::class.java)
}

class Person(var id: Int, var name: String)

fun test(){
    fromJson<Person>("""{"id": 0, "name": "Jack" }""")
}