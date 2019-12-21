@file:JvmMultifileClass
@file:JvmName("ManyUtils")
package ca.six.kjdemo.mutual.kt

fun String.firstOne(): String {
    return this.substring(0, 1)
}

fun Int.plus10(): Int {
    return this + 10
}

