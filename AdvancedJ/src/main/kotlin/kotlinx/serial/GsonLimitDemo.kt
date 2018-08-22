package kotlinx.serial

import com.google.gson.Gson
import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

@Serializable
class Data(val a: Int, @Optional val b: String = "42") {
    @Optional private val c: Long = 9L

//    @delegate:Transient val d by lazy { b.length }

    override fun toString(): String {
        return "Data(a=$a, b='$b', c=$c)"
    }
}

fun main(args: Array<String>) {
    val jsonString = """{"a":22}"""

    val obj1 = JSON.parse<Data>(jsonString)
    println("szw ktex = $obj1")  //=> Data(a=22, b='42', c=9)

    val obj2 = Gson().fromJson<Data>(jsonString, Data::class.java)
    println("szw gson = $obj2")  //=> Data(a=22, b='null', c=0)
}
