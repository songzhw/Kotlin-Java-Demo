package ca.six.kjdemo.monky

class Target3 {
    private val id = 200
}

fun Target3.readId(): Int{
//    return this.id; // ERROR!
    return 1
}

fun main() {

}