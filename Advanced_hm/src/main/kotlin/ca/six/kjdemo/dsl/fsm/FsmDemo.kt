package ca.six.kjdemo.dsl.fsm

object Solid : State()
object Liquid : State()
object Gas : State()

object Freeze : Event()
object Melt : Event()
object Vaporize : Event()
object Condense : Event()

fun main() {
    val fsm = stateMachine {
        initState(Gas)
        state(Gas) {
            on(Condense, dest = Liquid)
        }
        state(Liquid) {
            on(Freeze, dest = Solid)
            on(Vaporize, dest = Gas)
        }
    }
}

open class State
open class Event

class StateBuilder {
    val stateMap = HashMap<Event, State>()
    fun on(event: Event, dest: State) {
        stateMap[event] = dest
    }
}

class MachineBuilder {
    lateinit var state: State
    val stateMap = HashMap<State, HashMap<Event, State>>()

    fun initState(state: State) {
        this.state = state
    }

    fun state(state: State, block: StateBuilder.() -> Unit) {
        val stateBulder = StateBuilder()
        block(stateBulder)
        stateMap[state] = stateBulder.stateMap
    }
}

fun stateMachine(block: MachineBuilder.() -> Unit): MachineBuilder {
    val machine = MachineBuilder()
    block(machine)
    return machine
}