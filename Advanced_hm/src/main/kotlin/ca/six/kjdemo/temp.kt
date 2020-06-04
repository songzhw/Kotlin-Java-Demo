package ca.six.kjdemo


class Item {
    val name: Lazy<String> = lazy { "sze" }
    val id: String by lazy { "23" }

    fun foo() {
        id.toInt()
    }
}