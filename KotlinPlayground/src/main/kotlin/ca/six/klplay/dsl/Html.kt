package ca.six.klplay.dsl

class Html : Tag(){

    fun head(work: Head.()->Unit) : Head  = childWork(Head(), work)

    fun body(work: Body.()->Unit) : Body =  childWork(Body(), work)

    fun test(a : Int) : String {
        return "$a"
    }

}

fun html(block : Html.() -> Unit) : Unit {
    val html = Html()
    html.block()
}

fun main(args: Array<String>) {
    html {
        head {
            +"[head]"
            title {
                +"head - title"
            }
            println("${this.sb}") //=> [head] \n head -title
        }
        body {  }
        test(23)
    }
}