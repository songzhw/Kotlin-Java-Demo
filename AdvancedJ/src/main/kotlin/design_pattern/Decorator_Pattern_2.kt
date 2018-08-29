package design_pattern

class Text(var text : String){
    fun drawText() = print(text)
}

fun Text.underline(before : Text.() -> Unit){
    println("underline $text")
    this.text = this.text + "__"
    this.before()
}

fun Text.bold(before: Text.()-> Unit){
    println("bold $text")
    this.text = "**"+this.text+"**"
    this.before()
}

fun main(args: Array<String>) {
    // run的定义: public inline fun <R> run(block: () -> R): R = block()

    Text("Click Me").run {
        underline {
            bold {
                drawText()
            }
        }
    }
}


/*

注意调用顺序

underline Click Me
bold Click Me__
**Click Me__**

 */