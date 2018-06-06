package ca.six.kex.function

import kotlin.reflect.KFunction0

fun foo(): KFunction0<Unit> {
    var a = 1
    fun inner(){
        a++
        println("a = $a")
    }
    return ::inner
}

fun main(args: Array<String>) {
    var func = foo()
    func() //=> 2
    func() //=> 3
    func() //=> 4

    foo() // nothing happens
    foo() // nothing happens
}