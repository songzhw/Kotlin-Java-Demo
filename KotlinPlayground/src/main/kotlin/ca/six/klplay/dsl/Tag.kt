package ca.six.klplay.dsl

open class Tag() {
    val children = arrayListOf<Tag>()
    val sb = StringBuilder()

    fun <T : Tag> childWork(obj : T, work : T.()->Unit) : T {
        obj.work()
        children.add(obj)
        return obj
    }

    operator fun String.unaryPlus() {
        sb.append(this) // 这个this可是指String @
        sb.append("\n")
    }
}

class Body : Tag() {
}

class Head : Tag() {
    fun title(block : () -> Unit){
        block()
    }
}
