package ca.six.kjdemo.dsl

fun foo3(myblock: ()->Unit){
    myblock(333)
}

fun foo4(myblock: StringBuilder.()->Unit){
    myblock()
}

fun main() {
    foo4 {
        append("001")
        print(this) //=> szw001
    }
}