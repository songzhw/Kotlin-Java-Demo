package ca.six.kjdemo.dsl

sealed class Event10 {
    object Work: Event10()
    object Run: Event10()
}

fun perform(event: Event10){
    println(event)
}

fun main() {
    perform(Event10.Work)
}