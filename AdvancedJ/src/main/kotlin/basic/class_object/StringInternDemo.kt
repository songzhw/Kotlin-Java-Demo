package basic.class_object

class Anx

fun main(args: Array<String>) {
    val obj = Anx()
    val s1 = f1(obj)
    val s2 = f2(obj)
    println("$s1, $s2, equals? = ${s1 == s2}")
}

fun f1(obj: Anx) : String{
    return obj.javaClass.simpleName
}


fun f2(obj: Anx) : String{
    return obj.javaClass.simpleName
}