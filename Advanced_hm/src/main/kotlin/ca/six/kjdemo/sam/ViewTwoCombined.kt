package ca.six.kjdemo.sam

interface IViewTwoOnClickListener {
    fun onClick(vie: ViewTwo)
}

class ViewTwo {
    fun setOnClickListener(listener: IViewTwoOnClickListener) {
        println("two: $listener")
    }

    fun another(listener: IViewOneClickListener){
    }
}

fun main() {
    val target = ViewTwo()

    // 注意, 这里不能使用 target.setOnClickListener { view -> println(view) }
    target.setOnClickListener(object : IViewTwoOnClickListener {
        override fun onClick(vie: ViewTwo) {        }
    })

    // 注意, 这里同样不能使用 target.another { view -> println(view) }
    target.another(object: IViewOneClickListener {
        override fun click(view: ViewOne?) {        }
    })
}