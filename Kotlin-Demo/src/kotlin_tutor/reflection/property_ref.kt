package kotlin_tutor.reflection

/**
 * Created by songzhw on 2016/2/17.
 */

// To access properties as first-class objects in Kotlin, we can also use the :: operator:
var x = 1

val String.lastChar : Char
    get() = this[length - 1]

fun main(args: Array<String>) {
    // 1. simple example
    println(::x.get())  //=> 1

    ::x.set(2)
    println(::x.get())  //=> 2


    // 2. A property reference can be used where a function with no parameters is expected
    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length)) //=> [1, 2, 3]

    // 3. To access a property that is a member of a class, we qualify it
    class A(val p: Int)

    fun main(args: Array<String>) {
        val prop = A::p
        println(prop.get(A(1))) //=> "1"
    }

    // 4. For an extension property
    println(String::lastChar.get("abc")) //=> "c"


}

// "::X" is actually a "KProperty<Int>" object