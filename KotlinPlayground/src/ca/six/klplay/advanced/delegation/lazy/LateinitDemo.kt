package ca.six.klplay.advanced.delegation.lazy

class LazyInitDemo : Activity(){
    lateinit var textView : String
}

fun main(args: Array<String>) {
    val demo = LazyInitDemo()
//    println("${demo.textView}")   //=> NPE crash
    demo.textView="23"
    println("${demo.textView}")
}