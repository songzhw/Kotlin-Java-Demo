package pitfall

// 转为while循环, 所以return即让函数返回
fun return01(){
    (1..4).forEach{
        if(it > 2) return
        println(it)
    }
    println("end of return01() method")
}

fun returnForEach02(){
    (1..4).forEach{
        if(it > 2) return@forEach
        println(it)
    }
    println("end of method")
}

// 效果同returnForEach02()
fun return03(){
    (1..4).forEach lin@ {
        if(it > 2) return@lin
        println(it)
    }
    println("end of method")

}

fun returnStream(){
    (1..4).takeWhile { it <= 2 }
            .forEach{
                println(it)
            }
    println("end")
}

fun returnStream05(){
    (1..4).filter { it <= 2 }
            .forEach{
                println(it)
            }
    println("end")
}

fun main(args: Array<String>) {
//    return01()
//    returnForEach02()
//    return03()
//    returnStream()
    returnStream05()
}