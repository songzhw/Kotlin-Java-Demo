package ca.six.designpattern

data class User(val id: Int, val name: String, val isMale: Boolean, val age: Int) {}

class User2 {
    var id: Int = 0
    var name : String = ""
    var isMale = false
    var age = 0

    override fun toString(): String {
        return "User2(id=$id, name='$name', isMale=$isMale, age=$age)"
    }

}

fun main(args: Array<String>) {
    val user2 = User2()
    user2.apply {
        id = 23
        name = "szw"
        isMale = true
        age = 18
    }
    println("szw user2 = $user2")
}