package ca.six.kjdemo.mutual.kt

class MyStatic {
    companion object {
        val id = 23;
        fun foo() {
            println("foo")
        }
    }
}

class Static2 {
    companion object {
        @JvmStatic val id = 23;
        @JvmStatic fun foo() {
            println("foo")
        }
    }
}

fun main() {
    MyStatic.id
    Static2.id
}