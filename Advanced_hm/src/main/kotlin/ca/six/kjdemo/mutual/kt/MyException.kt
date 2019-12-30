package ca.six.kjdemo.mutual.kt

import java.lang.Exception

@Throws(Exception::class)
fun iThrow() {
    println("szw iThrow()")
    throw Exception("this is wrong")
}