package ca.six.kjdemo


val sum1: Int.(Int) -> Unit = { other -> plus(other) }
val sum2: Int.(Int) -> Int = { other -> plus(other) }

class FuncReceiver {
    fun f1(value: Int): String {
        return "str$value"
    }

    fun f2(arg: String): Int {
        return arg.hashCode()
    }

    fun f3(): Boolean {
        return false
    }

    fun f4() {}
}

fun r1(work: ()->Unit) {
    val ret = work()
    println("r1 = $ret")
}



fun main() {
    println(2.sum1(3))  //=> kotlin.Unit
    println(2.sum2(3))  //=> 5
}