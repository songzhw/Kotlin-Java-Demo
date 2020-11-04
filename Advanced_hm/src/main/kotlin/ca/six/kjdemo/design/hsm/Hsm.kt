package ca.six.kjdemo.design.hsm

sealed class Event
sealed class State

class StateMachine(val builder: StateBuilder) {
    companion object {
        fun create(init: StateBuilder.() -> Unit): StateMachine {
            val builder = StateBuilder().apply(init)
            return StateMachine(builder)
        }
    }
}

class StateBuilder {
    lateinit var state: State

    fun initialState(initState: State) {
        this.state = initState
    }
}


// = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
object Solid: State()
object Liquid: State()

fun main() {
    val sm = StateMachine.create {
        initialState(Solid)
    }
    print(sm)
}