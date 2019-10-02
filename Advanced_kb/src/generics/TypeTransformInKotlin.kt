package generics


interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    val intResult = x.compareTo(1.0)
    val y: Comparable<Double> = x // OK！
}

fun main() {

}