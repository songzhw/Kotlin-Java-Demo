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


//fun foo11(work: String.(arg: String)->Unit) {
//    work(arg)
//}


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
}