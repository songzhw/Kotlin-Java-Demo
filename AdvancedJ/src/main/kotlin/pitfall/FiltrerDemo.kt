package pitfall

fun main(args: Array<String>) {
    val list = listOf<Int>(2, 3, 4, 5, 6)

    list.filter { it % 2 == 0 }
            .forEach{ println(it)} //=> 2, 4, 6

    println("=========")

    list.takeWhile { it % 2 == 0 }
            .forEach{ println(it)} //=> 2
}