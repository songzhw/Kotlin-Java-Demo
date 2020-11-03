package ca.six.kjdemo.dsl

class Person(val id: Int){
    operator fun invoke(name: String) {
        println("$name($id)")
    }
}

fun main() {
    val szw = Person(23)
    szw("szw")  //=> szw(23)
}