package ca.six.kjdemo.mutual.kt

import ca.six.kjdemo.mutual.jva.ViewOne

fun main() {
    val target = ViewOne()
    target.setOnClickListener { view -> println(view) }
}