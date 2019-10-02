package generics

import java.util.ArrayList

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    val intResult = x.compareTo(1.0)
    val y: Comparable<Double> = x // OK！
}

fun main() {
    val list = ArrayList<Animal>()
    list.add(Cat())
    list.add(Animal())
    val anim = list[0]
}