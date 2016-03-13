package cn.song.agdelegate


/**
Administrator - 2015/8/16
Copyright 2015 Six.
 */


interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() {
        print(x)
    }
}

class Derived(b: Base) : Base by b

//fun main(args: Array<String>) {
//    val b = BaseImpl(10)
//    Derived(b).print() // prints 10
//}
