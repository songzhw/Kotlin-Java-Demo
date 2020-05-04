package ca.six.kjdemo.design

//TODO setDevice与setNagBtnText, 这两个方法互斥
class Biometric {
    var title = ""
    var subtitle = ""
    var description = ""
    var confirmationRequired = true

    // 所以外部只能使用Builder模式来构建此类
    private constructor() {}

    fun authenticate() {
        println(this)
    }

    companion object {
        fun build(init: Biometric.() -> Biometric): Biometric {
            return (with(Biometric(), init))
        }
    }
}

// 关键在于: inline fun <T, R> with(receiver: T, block: T.() -> R): R {
fun main() {
    val biometric = Biometric.build {
        title = "hello"
        subtitle = "hello world"
        description = "programming 101"
        confirmationRequired = false
        this // 返回值 (lambda中不能有return. 最后一句默认就是返回值)
    }
    biometric.authenticate()
}