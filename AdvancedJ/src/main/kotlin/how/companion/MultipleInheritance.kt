package how.companion

open class Mother{
    fun clam() {
        println("mother : clam down")
    }
}

open class Father {
    fun fight(){
        println("father : fight")
    }
}

class Son : Father() {
    companion object : Mother(){
    }
}

fun main(args: Array<String>) {
    val son = Son()
    son.fight()  //=> father : fight
    Son.clam()   //=> mother : clam down
}