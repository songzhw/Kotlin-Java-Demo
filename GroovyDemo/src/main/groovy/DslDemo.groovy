// 1. closure as method parameter
def tax(income, getRate) {
    rate = getRate() // getRate.call()也行. 即用closure.call()
    money = income * (1 - rate)
    println "money = $money"
}

tax(2000) {
    0.4
} //=> money = 1200.0

// =============================================

// 2. 命令链: 不用"."   也不要"()"
def first(arg1) {
    println "first($arg1)"
    this
}
def then(arg2) {
    println "then($arg2)"
}

// 等同于 first(23).then(9)
first 23 then 9

// =============================================