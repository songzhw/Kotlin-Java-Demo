class Bird {
    fun eat(food: String, action: (String) -> Unit): String {
        action(food)
        println("szw eat $food")
        return ""
    }

    fun sleep(): String = "test"

    fun zzz() = sleep()

    fun zzzzz() = this::sleep

    fun z(action: () -> String) {
        action()
    }


}

fun Bird.sing() = println("sing")

fun Bird.lunch(food: String, action: (String) -> Unit): String = this.eat(food) {
    action(food)
}


fun main(args: Array<String>) {
    val bird = Bird()
    bird.sing()
    bird.zzz()
    bird.zzzzz()
    bird.z(bird::sleep)
}