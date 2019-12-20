package ca.six.kjdemo.mutual.kt

interface IViewTwoOnClickListener {
    fun onClick(vie: ViewTwo)
}

class ViewTwo {
    fun setOnClickListener(listener: IViewTwoOnClickListener) {
        println("two: $listener")
    }
}

fun main() {
    val target = ViewTwo()

    // 注意, 这里不能使用 target.setOnClickListener { view -> println(view) }
    target.setOnClickListener(object : IViewTwoOnClickListener{
        override fun onClick(vie: ViewTwo) {
        }
    })
}