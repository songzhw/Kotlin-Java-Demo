package kotlin_sample.builder

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */
abstract class Tag(var name : String){
    var children = arrayListOf<Any>()
    protected fun <T : Any> initTag(tag: T, init: T.()-> Unit) : T{
        tag.init()
        children.add(tag)
        return tag
    }

    override fun toString(): String {
        var sb = StringBuilder()
        sb.append("<${name}>\n")
        children.forEach {
            sb.append("${it.toString()}")
        }
        sb.append("\n")
        sb.append("</${name}>\n")
        return sb.toString()
    }
}

fun html(init: Html.()-> Unit) : Html {
    var html = Html()
    html.init()
    return html
}


class Html() : Tag("html") {
    fun head(init: Head.()->Unit) : Head = initTag(Head(), init)
}

class Head() : Tag("head"){
    fun title(content : String) : Title {
        var title = Title(content)
        children.add(title)
        return title
    }
}

class Title(var content : String){
    override fun toString(): String {
        return "\t\t<title>${content}</title>"
    }
}
