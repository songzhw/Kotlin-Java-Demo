package cn.song.ccBuilder

/**
 * Created by hzsongzhengwang on 2015/9/11.
 */
fun html(init: Html.()-> Unit) : Html {
    var html = Html()
    html.init()
    return html
}


class Html(){
    var children = arrayListOf<Any>()

    fun head(init: Head.()->Unit) : Head{
        var head = Head()
        head.init()
        children.add(head)
        return head
    }

    override fun toString(): String {
        var sb = StringBuilder()
        sb.append("<html>\n")
        children.forEach {
            sb.append("    ${it.toString()}")
        }
        sb.append("\n")
        sb.append("</html>\n")
        return sb.toString()
    }
}

class Head(){
    override fun toString(): String {
        return "<head></head>"
    }
}
