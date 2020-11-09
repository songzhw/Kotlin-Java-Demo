package ca.six.kjdemo.dsl.html

import java.lang.StringBuilder

fun main() {
    val result = html {
        body {
            h1("hello")
            span("world")
        }
    }
    print(result)
}


class BodyBuilder(val sb: StringBuilder) {

    fun h1(text: String) {
        sb.append("\t\t<h1>$text</h1>\n")
    }

    fun span(text: String) {
        sb.append("\t\t<span>$text</span>\n")
    }
}

class HtmlBuilder(val sb: StringBuilder) {

    fun body(block: BodyBuilder.() -> Unit) {
        sb.append("\t<body>\n")
        block(BodyBuilder(sb))
        sb.append("\t</body>\n")
    }

}

fun html(block: HtmlBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.append("<html>\n")
    block(HtmlBuilder(sb))
    sb.append("</html>\n")
    return sb.toString()
}