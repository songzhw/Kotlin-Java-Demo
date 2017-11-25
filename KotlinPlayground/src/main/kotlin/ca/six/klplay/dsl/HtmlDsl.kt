/*
package ca.six.klplay.dsl

class Html {
    fun head(){ println("head") }
    fun body(){ println("body") }
}

// 函数参数是指: Html的一个方法, 此方法入参无, 返回为Unit
fun html(aMethod: Html.()->Unit) : Html {
    val html = Html();
    html.aMethod()
    return html
}

fun main(args: Array<String>) {
    html {
        head()
        body()
    }
}
*/
