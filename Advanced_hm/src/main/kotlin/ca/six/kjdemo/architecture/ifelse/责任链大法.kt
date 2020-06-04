package ca.six.kjdemo.architecture.ifelse

fun original22(income: Int) {
    var tax = 0.0
    if (income < 5200) {
        tax = 0.0
    } else if (income < 8000) {
        tax = 0.14 * (income - 5200)
    } else if (income < 20000) {
        tax = 392 + 0.25 * (income - 8000) //392就是 0.14 * (8000 - 5200)
    } else {
        tax = 3392 + 0.5 * (income - 20000)
    }
    println("original : $tax")
}

interface ITaxCalculator {
    var next: ITaxCalculator?
    fun meetCondition(income: Int): Boolean
    fun getTax(income: Int): Double

    fun calculate(income: Int): Double {
        println("interface $income, meet? = ${meetCondition(income)}")
        if (meetCondition(income)) {
            return getTax(income)
        } else {
            return next!!.getTax(income)
        }
    }
}

class Level1 : ITaxCalculator {
    override var next: ITaxCalculator? = null

    override fun meetCondition(income: Int) = income < 5200

    override fun getTax(income: Int): Double {
        println("1")
        return 0.0
    }

}

class Level2 : ITaxCalculator {
    override var next: ITaxCalculator? = null

    override fun meetCondition(income: Int) = income < 8000

    override fun getTax(income: Int): Double {
        println("2")
        return 0.14 * (income - 5200)
    }

}

class Level3 : ITaxCalculator {
    override var next: ITaxCalculator? = null

    override fun meetCondition(income: Int) = income < 20000

    override fun getTax(income: Int): Double {
        println("3")
        return 392 + 0.25 * (income - 8000)
    }

}

class Level4 : ITaxCalculator {
    override var next: ITaxCalculator? = null

    override fun meetCondition(income: Int) = income >= 20000

    override fun getTax(income: Int): Double {
        println("4")
        return 3392 + 0.5 * (income - 20000)
    }

}

fun refactor22(income: Int) {
    val lvl1 = Level1()
    val lvl2 = Level2()
    val lvl3 = Level3()
    val lvl4 = Level4()
    lvl1.next = lvl2
    lvl2.next = lvl3
    lvl3.next = lvl4

    val tax = lvl1.calculate(income)
    println("tax = $tax")

}

fun main() {

    refactor22(20000)
}