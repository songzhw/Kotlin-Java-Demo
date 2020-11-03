package ca.six.kjdemo.dsl

fun foo3(myblock: ()->Unit){
    myblock()
}

fun foo4(myblock: StringBuilder.()->Unit){
    myblock(StringBuilder())
}

fun foo5(block: StringBuilder.()->Int){
    block(StringBuilder())
}


fun foo11(work: Int.(arg1: String, arg2: Int)->Boolean) {
    work(30, "x", 23)
}


fun main() {
    foo4 {
        append("001")
        print(this) //=> szw001
    }


    foo5 {
        append("abc")
        append("123")
        30
    }

    foo11 { arg1, arg2 ->
        println("arg1 = $arg1, arg2=$arg2")  //=> arg1 = x , arg2=23
        val longValue = this.toLong()  //Int的方法
        true         //指明要返回Boolean
    }


}