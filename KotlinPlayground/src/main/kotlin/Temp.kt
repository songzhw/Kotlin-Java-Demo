import java.net.URL

data class A(val id: Int, val time: Long) {
}

fun main(args: Array<String>) {
    val list: List<A> = arrayListOf<A>(A(11, 20), A(23, 20), A(11, 23), A(17, 24))
    list
            .sortedWith(Comparator<A> { a1, a2 ->
                if (a1.id == a2.id) {
                    a2.time.compareTo(a1.time)
                } else {
                    a2.id.compareTo(a1.id)
                }
            })
//            .take(3)
            .forEach { A ->
                println("$A")
            }
/*
Comparator<A> { a1, a2 ->
                a2.id.compareTo(a1.id)
            }
 */

}