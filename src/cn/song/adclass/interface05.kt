package cn.song.adclass

/**
 * Created by hzsongzhengwang on 2015/8/18.
 */

interface MyInterface {
    val pro : Int  // must be abstract
    fun bar()
    fun foo() { // can have method implementation
        println("foo")
    }
}

// must implement the abstract methods
class Child1 : MyInterface{
    override val pro: Int = 29
    override fun bar() {}
}


//======================================
interface A33 {
    fun foo() { print("A33") }
    fun bar()
}

interface B33 {
    fun foo() { print("B33") }
    fun bar() { print("B33 bar33") }
}

class C33 : A33 {
    override fun bar() { print("C33 bar") }
}

class D33 : A33, B33 {
    override fun foo() {
        super<A33>.foo()
        super<B33>.foo()
    }
}

//fun main(args: Array<String>) {
//    var d33 = D33()
//    d33.bar() //=> B33 bar33
//}

//======================================

interface A34 {
    fun foo()
}

interface B34{
    fun foo()
}

class D34 : A34, B34{
    override fun foo() {
    }
}
