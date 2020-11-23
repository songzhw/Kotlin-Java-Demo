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

    fsm.act(Freeze)
    println("01 : ${fsm.state}")  //=> 仍是Gas. 因为对Gas对Freeze事件是不响应的
    fsm.act(Condense)
    println("02 : ${fsm.state}")  //=> Liquid
    fsm.act(Vaporize)
    println("03 : ${fsm.state}")  //=> Gas
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

    fun act(event: Event) {
        val stateMap2 = stateMap[state]
        if (stateMap2 == null) return;
        val destinationState = stateMap2[event]
        if (destinationState == null) return;
        this.state = destinationState
    }

}

fun stateMachine(block: MachineBuilder.() -> Unit): MachineBuilder {
    val machine = MachineBuilder()
    block(machine)
    return machine
}