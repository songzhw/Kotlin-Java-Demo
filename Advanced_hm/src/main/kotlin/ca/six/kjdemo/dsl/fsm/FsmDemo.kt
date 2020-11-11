package ca.six.kjdemo.dsl.fsm

object Solid : State()
object Liquid : State()
object Gas : State()

object freeze : Event()
object Melt : Event()
object vaporize : Event()
object Condense : Event()

fun main() {
    val fsm = stateMachine {
        initState(Gas)
        state(Gas) {
            on(Condense, dest = Liquid)
        }
    }
}

open class State
open class Event

class StateBuilder {
    fun on(event: Event, dest: State) {

    }
}

class MachineBuilder {
    lateinit var state: State

    fun initState(state: State) {
        this.state = state
    }

    fun state(state: State, block: StateBuilder.() -> Unit) {

    }
}

fun stateMachine(block: MachineBuilder.() -> Unit) {
    block(MachineBuilder())
}