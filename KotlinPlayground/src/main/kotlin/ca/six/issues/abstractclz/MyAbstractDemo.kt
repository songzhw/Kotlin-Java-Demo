package ca.six.issues.abstractclz

fun main(args: Array<String>) {
    val obj = object : MyAbstractClass(23) {
        override fun bar() { // 用protected则会访问不了 obj.bar()
            println("   : from client.bar()")
        }
    }
    obj.foo()
}
