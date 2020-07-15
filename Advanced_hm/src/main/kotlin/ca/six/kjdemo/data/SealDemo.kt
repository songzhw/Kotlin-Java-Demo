package ca.six.kjdemo.data

sealed class SealedExpr {
    data class Person(val num1: Int, val num2: Int) : SealedExpr()

    object Add : SealedExpr()   // 单例模式
    object Minus : SealedExpr() // 单例模式
}

// 其子类可以定在密封类外部，但是必须在同一文件中。`v1.1`之前只能定义在密封类内部
object NotANumber : SealedExpr()

// =======================

enum class Size {
    S, M, L
}

enum class Color3(rgb: String) {
    RED("#f00"),
    WHITE("#ff")
}

fun enumDemo(size: Size) {
    when (size) {
        Size.S -> println("small")
    }
}


// =======================
//
sealed class UIState<T>

object Start : UIState<Unit>()
data class Succ<T>(val t: T) : UIState<T>()
data class Fail(val exception: Throwable) : UIState<Unit>()


fun <T> sealDemo(state: UIState<T>) {
    when (state) {
        is Start -> println("szw start")
    }
}


/*

 */