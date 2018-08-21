package kotlinx.serial

import kotlinx.serialization.json.JSON
import java.util.*

fun main(args: Array<String>) {
//    val resp = """{"code":100,"msg":"success","payload":{"imgUrl":"http://192.168.2.26:8899/images/splash/splash3.jpg"}}"""
    var resp1 = """ {  "id":2000, "name":"szw"  }  """
    val user1 = JSON.parse<User>(resp1)
    println("szw $user1")


    var resp2 = JSON.stringify(User(122, "test", true))
    println("szw $resp2")

    var date = Calendar.getInstance().apply { set(2018, 8, 18, 14, 52, 10) }.time
    println("szw $date")   //=> 即Date类型的toString()是: "Tue Sep 18 14:52:10 EDT 2018"的样式

    /*
    若没有自定义Date的解析方式, 那结果就是: {"code":200,"msg":"sueess","timestamp":"Tue Sep 18 14:52:10 EDT 2018"}
    若定义了, 则结果是:  {"code":200,"msg":"sueess","timestamp":"2018-09-18 14:52:10"}
     */
    println(JSON.stringify(Response(200, "sueess", date)))
}
