package design_pattern

// java版就是一个接口Beverage, 其有子类Milk, Mocha,... . 它们之间可以互相套
// Kotlin版就更方便了,

interface CoffeePart {
    fun cost(): Double
}

class DarkRoast : CoffeePart {
    override fun cost(): Double {
        return 0.99
    }
}

class Mocha(val before: CoffeePart) : CoffeePart {
    override fun cost(): Double {
        return 0.5 + before.cost()
    }
}

class Whip(val before: CoffeePart) : CoffeePart {
    override fun cost(): Double {
        return 0.3 + before.cost()
    }
}

fun main(args: Array<String>) {
    // 两份Mocha, 一份whip的DarkRoast
    var drink: CoffeePart = DarkRoast()
    drink = Mocha(drink)
    drink = Mocha(drink)
    drink = Whip(drink)
    println("szw price = ${drink.cost()}")  //=> 2.29
}

