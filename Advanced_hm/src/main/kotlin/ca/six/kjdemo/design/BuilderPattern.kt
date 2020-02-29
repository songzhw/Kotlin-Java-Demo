package ca.six.kjdemo.design

//TODO setDevice与setNagBtnText, 这两个方法互斥
class Biometric {
    var title = ""
    var subtitle = ""
    var description = ""
    var confirmationRequired = true

    fun authenticate() {

    }
}

fun main() {
    val biometric = with(Biometric()) {
        title = "hello"
        subtitle = "hello world"
        description = "programming 101"
        confirmationRequired = false
        this // 返回值 (lambda中不能有return. 最后一句默认就是返回值)
    }
    biometric.authenticate()
}