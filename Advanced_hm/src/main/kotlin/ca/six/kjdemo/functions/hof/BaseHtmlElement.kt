package ca.six.kjdemo.functions.hof

// <html>这种元素就只有children, 基本没有content.  <span>这种就又有content又有name.
open class BaseHtmlElement(val name: String, val content: String = "") : HTMLElement{
    val children = ArrayList<HTMLElement>()
    val attrs = HashMap<String, String>() //存<img src alt>中的src与alt的

    override fun render(sb: StringBuilder, indent: String): String {
        sb.append("$indent<$name>\n")
        if(content.isNotBlank()){ //全是空格也会返回true
            sb.append("$indent$indent$content\n")
        }
        children.forEach { it.render(sb, "$indent$indent") }
        sb.append("$indent</$name>\n")
        return sb.toString()
    }
}