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




    // This is wrong, as kotlin does not support kotlin's SAM
    // obj.setClickListener(IClickListener { id -> println() })

}