package ca.six.kjdemo.dsl.html

import java.lang.StringBuilder

fun main() {
    val html = HtmlBuilder()
    html.body {
        h1   "hello"
        span "world"
    }
}
/*
html {
    header {
        title "hello world"
    }
    body {
        h1 "kotlin DSL"
        span "first line"
    }
}
 */


class BodyBuilder {
    val sb = StringBuilder()

    fun h1(text: String) {
        sb.append("<h1>$text</h1>")
    }

    fun span(text: String) {
        sb.append("<span>$text</span>")
    }
}

class HtmlBuilder {
    val sb = StringBuilder()

    fun body(block: BodyBuilder.() -> Unit) {
        block(BodyBuilder())
    }

}