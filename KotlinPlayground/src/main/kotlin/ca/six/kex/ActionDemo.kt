package ca.six.kex

class ActionDemo {
    fun foo() {
        val result = "Hello World".also {
            println("this = $this")
            println("it = $it")
        }

        println("result = $result")
    }

    fun takeif(){
        val ret = "hello".takeIf {
            it.length > 10 // it是个string
        }
        println("ret2 = $ret") //=> hello
    }
}

fun main(args: Array<String>) {
    val obj = ActionDemo()
    obj.foo();
    obj.takeif()
}

/*
this = ca.six.kex.ActionDemo@355da254
it = Hello World
result = Hello World

ret2 = hello
 */