package ca.six.kjdemo.functions.hof


class P(content: String) : BaseHtmlElement("p", content)
class H1(content: String) : BaseHtmlElement("h1", content)

class Body : BaseHtmlElement("body") {
    fun h1(block: () -> String): H1 {
        val content = block()
        val h1 = H1(content)
        this.children += h1
        return h1
    }

    fun p(block: () -> String): P {
        val content = block()
        val p = P(content)
        this.children += p
        return p
    }
}

class HTML : BaseHtmlElement("html") {
    fun body(block: Body.() -> Unit): Body {
        val body = Body()
        body.block()
        this.children += body
        return body
    }
}

fun html(block: HTML.() -> Unit): HTML {
    val html = HTML()
    html.block()
    return html
}

fun main() {
    val str =
        html {
            body {
                h1 { "Hello World" }
                p { "welcome to the high order of function in Koblin" }
                h1 { "Introduction" }
            }
        }
    println(str)
}