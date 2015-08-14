package cn.song.adclass

/**
 * Created by hzsongzhengwang on 2015/8/14.
 */

class Invoice1 {}

// primary constructor
class Person1(firstName: String) {}
class Person2(val firstName: String, val lastName: String, var age: Int) { }

// primary constructor with code
class Customer1(name: String) {
    var key = name.toUpperCase()
    init {
        println("Customer initialized with value ${name}")
    }
}

// secondary constructor : needs delegate to the primary constructor, using the "this" keyword
data class Person3(val name: String,  id: Long) {
    constructor(name: String) : this(name, -1L){ }
}







// need a main entrance, which is not like groovy or ruby, it's not a script language
fun main(args: Array<String>){
    println(Person3("szw", 100))

    var invoice = Invoice1()
    var p1 = Person1("name")
//    var p2 = Person2.getInstance()

}
