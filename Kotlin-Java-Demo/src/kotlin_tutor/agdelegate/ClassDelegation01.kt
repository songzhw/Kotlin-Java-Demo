package cn.song.agdelegate


/** songzhw - 2016/2/17 */


interface Base1 {
    fun print()
}

class BaseImpl1(val x: Int) : Base1 {
    override fun print() {
        print(x)
    }
}

class Derived1(b: Base1) : Base1 by b

fun main(args: Array<String>) {
    val b = BaseImpl1(10)
    Derived1(b).print() // prints 10
}
