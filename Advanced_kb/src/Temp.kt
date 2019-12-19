import java.util.*

//fun main() {
//    val split = "OEBPS/Brow_chapter2.html:my.2.1".split(":")
//    val chapterPath = split.get(0)
//    val tagId = split.get(1)
//    println(chapterPath)
//    println(tagId)
//
//    val another = "".split(":")
//    println(another)
//}


internal class User {
    var name = "songzhw"
}

internal interface IRvType<T> {
    fun render(datum: T)
}

internal class Adapter(
    var data: List<*>,
    var props: Map<Class<*>, IRvType<*>>
) {
    fun onRender(clazz: Class<*>?, position: Int) {
        val type = props[clazz]
        val value = data[position]!!
        type!!.render(value)
    }

}

fun main() {
    val one: IRvType<String> = object : IRvType<String?> {
        override fun render(datum: String) {
            println("render string: $datum")
        }
    }
    val two: IRvType<User> = object : IRvType<User?> {
        override fun render(datum: User) {
            println("render user: " + datum.name)
        }
    }
    val map: MutableMap<Class<*>, IRvType<*>> = HashMap()
    map[String::class.java] = one
    map[User::class.java] = two
    val data: MutableList<*> = ArrayList<Any?>()
    data.add("200")
    data.add(User())
    val adapter = Adapter(data, map)
}
}