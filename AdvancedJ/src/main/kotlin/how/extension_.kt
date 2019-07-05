package how

class One {
    fun work(){
        println("001")
    }
}

fun One.work(){
    println("002")
}

fun main() {
    One().work() //=> 001
}