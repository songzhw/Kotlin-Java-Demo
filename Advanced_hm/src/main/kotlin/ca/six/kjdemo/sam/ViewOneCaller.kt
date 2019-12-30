package ca.six.kjdemo.sam

import ca.six.kjdemo.sam.ViewOne

fun main() {
    val target = ViewOne()
    target.setOnClickListener { view -> println(view) }
}