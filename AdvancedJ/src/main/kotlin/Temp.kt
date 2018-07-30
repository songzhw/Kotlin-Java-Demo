class Bird {
    fun eat(food: String, action: (String) -> Unit) {
        action(food)
        println("szw eat $food")
    }
}

fun Bird.lunch(food: String, action: (String) -> Unit) : String = this.eat(food){
    return "done";
}


