package function.sam

class SamDemo {
    fun setCheckListener(checker: ICheckListener) {}
    fun setClickListener(clicker: IClickListener) {}
}

fun main() {
    val obj = SamDemo()

    obj.setCheckListener(object : ICheckListener {
        override fun onChceck(isCheck: Boolean) {

        }
    })

    // the lambda version is:
    obj.setCheckListener(ICheckListener { })
    // obj.setCheckListener{isCheck -> println(isCheck)} // ERROR!


    val checkObj = CheckDemo()
    checkObj.setChecker { isCheck -> println(isCheck) }
    checkObj.setChecker(ICheckListener {  })
    checkObj.setChecker(object : ICheckListener{
        override fun onChceck(isCheck: Boolean) {
        }
    })

    // This is wrong, as kotlin does not support kotlin's SAM
    // obj.setClickListener(IClickListener { id -> println() })

    obj.setClickListener(object : IClickListener {
        override fun onClick(id: Int) {
        }
    })
}