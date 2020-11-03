package ca.six.kjdemo.dsl

fun foo3(myblock: ()->Unit){
    myblock()
}

fun foo4(myblock: StringBuilder.()->Unit){
    myblock(StringBuilder())
}

fun main() {
    foo4 {
        append("001")
        print(this) //=> szw001
    }
}