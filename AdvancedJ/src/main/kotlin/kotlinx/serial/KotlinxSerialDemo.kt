package kotlinx.serial

import kotlinx.serialization.json.JSON

fun main(args: Array<String>) {
//    val resp = """{"code":100,"msg":"success","payload":{"imgUrl":"http://192.168.2.26:8899/images/splash/splash3.jpg"}}"""
    var resp1 = """ {  "id":2000, "name":"szw"  }  """
    val user1 = JSON.parse<User>(resp1)
    println("szw $user1")

}
