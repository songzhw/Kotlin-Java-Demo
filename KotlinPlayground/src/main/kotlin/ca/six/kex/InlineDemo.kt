package ca.six.kex

fun nonInlined(block: () -> Unit) {
    println("before")
    block()
    println("after")
}

internal fun inlined(block: ()->Unit) {
    println("before")
    block()
    println("after")
}

fun main(args: Array<String>) {
    nonInlined {
        println("do something here")
    }

    inlined {
        println("do something here")
    }
}

