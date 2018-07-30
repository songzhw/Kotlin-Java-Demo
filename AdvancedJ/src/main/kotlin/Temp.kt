class Bird {
    fun eat(food: String, action: (String) -> Unit): String {
        action(food)
        println("szw eat $food")
        return ""
    }
}

fun Bird.sing() = println("sing")
fun Bird.sleep() : String = println("test")

//fun Bird.lunch(food: String, action: (String) -> Unit): String = this.eat(food) {
//    return@eat "done"
//}


fun main(args: Array<String>) {
    Bird().sing()
}