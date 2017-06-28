package ca.six.klplay.advanced.delegation


import kotlin.properties.Delegates

class User2 {
    var name: String by Delegates.vetoable("<no name>") { prop, old, new ->
        println("$old -> $new")
        false
    }
}

fun main(args: Array<String>) {
    val user = User2()
    user.name = "first"
    user.name = "second"
    println(user.name)
}

/*
User2 has a delegation member : ReadWriteProperty
 */