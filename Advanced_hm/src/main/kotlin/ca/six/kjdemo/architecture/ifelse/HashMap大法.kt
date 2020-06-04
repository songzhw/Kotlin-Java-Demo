package ca.six.kjdemo.architecture.ifelse

enum class Condition11 {
    ONE,
    TWO,
    THREE,
    FOUR
}

fun original(condition: Condition11) {
    if (condition === Condition11.ONE) {
        println("001")
    } else if (condition === Condition11.TWO) {
        println("002")
    } else if (condition === Condition11.THREE) {
        println("003")
    } else {
        println("004")
    }
}

fun refactor11(condition: Condition11) {
    val actions = HashMap<Condition11, () -> Unit>()
    // actions.put(Condition11.ONE, ()->{ println("001"); }) //ERROR
    actions.put(Condition11.ONE, { println("001"); })
    actions.put(Condition11.TWO, { println("002"); })
    actions.put(Condition11.THREE, { println("003"); })

    actions[condition]?.invoke() ?: println("new 004")
}


fun main() {
    original(Condition11.FOUR)

    refactor11(Condition11.FOUR)
}
