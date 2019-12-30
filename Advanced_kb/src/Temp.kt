import io.reactivex.Observable

fun main() {
    Observable.range(0, 6)
        .scan(12) { a, b ->
            println("szw a = $a, b = $b")
            a + b
        }
        .subscribe { println(it) }
}