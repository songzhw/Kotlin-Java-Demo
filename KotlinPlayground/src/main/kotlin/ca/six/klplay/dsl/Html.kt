package ca.six.klplay.dsl

class Html : Tag(){

    fun head(work: Head.()->Unit) : Head  = childWork(Head(), work)

    fun body(work: Body.()->Unit) : Body =  childWork(Body(), work)

}

fun html(block : Html.() -> Unit) : Unit {
    val html = Html()
    html.block()
    println("szw block : ${block.toString()}")
}

fun main(args: Array<String>) {
    html {
        println("szw")
        head {
            +"[head]"
            title {
                +"head - title"
            }
            println("${this.sb}") //=> [head] \n head -title
        }
        body {  }
    }
}