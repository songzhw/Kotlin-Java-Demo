package ca.six.kjdemo.dsl

fun foo3(myblock: ()->Unit){
    myblock()
}

fun foo4(myblock: StringBuilder.()->Unit){
    myblock(StringBuilder())
}


class FuncReceiver {
    fun f1(value: Int): String {
        return "str$value"
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
    foo4 {
        append("001")
        print(this) //=> szw001
    }

    val ret1 = r1 {
        work()
        println("r1 inside")
        println(f1(33))
        f4()
        3
    }
    println("main ret = $ret1")
}