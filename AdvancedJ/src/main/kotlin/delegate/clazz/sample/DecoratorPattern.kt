package delegate.clazz.sample

interface IBeverage {
    fun name(): String
    fun cost(): Double
}

class Mocha(val anotherBeverage: IBeverage) : IBeverage by anotherBeverage {
    override fun cost(): Double {
        return anotherBeverage.cost() + 0.25
    }
}