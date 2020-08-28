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

    fun f4() {
        println("f4")
    }
}

fun work(){
    println("work")
}


fun r1(work: FuncReceiver.()->Unit) {
    val obj = FuncReceiver()
    val ret = obj.work()
    println("r1 = $ret")
}


fun main() {
    val ret1 = r1 {
        work()
        println("r1 inside")
        println(f1(33))
        f4()
        3333
    }



    println("main ret = $ret1")
}