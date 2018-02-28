// 1. closure as method parameter
def tax(income, getRate) {
    rate = getRate() // getRate.call()也行. 即用closure.call()
    money = income * (1 - rate)
    println "money = $money"
}

tax(2000) {
    0.4
} //=> money = 1200.0

tax 23, {
    0.2
} //=> money = 18.4

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
// => first(23)
// => then(9)

// =============================================

def action(closure) {
    closure.call()
    this
}

first 23 action {
    println "test dsl"
}

// =============================================

def fun1(a){}
fun1 13  //只要不是无参, 方法调用时就可以省略()


def apply(Map<String, String> args) {
    args.forEach { key, value ->
        println("szw $key $value")
    }
}

//=> szw plugin groovy
apply([plugin: 'java'])
// apply [plugin: 'java']  // 这种不行, 会出错. 可能是在省了()后只用[]有歧义
apply plugin: "groovy"   // 若key是普通字符串, 还可以省略掉绰号
