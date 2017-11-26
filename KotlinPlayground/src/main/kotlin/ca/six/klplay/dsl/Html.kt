package ca.six.klplay.dsl

class Html {
    val children = arrayListOf<Tag>()

    fun head(work: Head.()->Unit) : Head  = childWork(Head(), work)

    fun body(work: Body.()->Unit) : Body =  childWork(Body(), work)

    fun <T : Tag> childWork(obj : T, work : T.()->Unit) : T {
        obj.work()
        children.add(obj)
        return obj
    }
}

fun html(block : Html.() -> Unit) : Unit {
    val html = Html()
    html.block()
}

fun main(args: Array<String>) {
    html {
        head {  }
        body {  }
    }
}