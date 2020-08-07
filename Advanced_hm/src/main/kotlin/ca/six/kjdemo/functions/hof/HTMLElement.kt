package ca.six.kjdemo.functions.hof

interface HTMLElement {
    fun render(sb: StringBuilder, indent: String): String
}