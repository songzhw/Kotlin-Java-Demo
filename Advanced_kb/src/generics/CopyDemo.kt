package generics

import generics.java.data.Animal
import generics.java.data.Cat

fun <T> copyList(dest: MutableList<T>, src: List<T>) {
    src.forEachIndexed { index, element ->
        dest.add(element)
    }
}

fun main() {
    val cats1 = ArrayList<Cat>()
    val cats2 = ArrayList<Cat>()
    val animals1 = ArrayList<Animal>()
    val animals2 = ArrayList<Animal>()

    copyList(cats1, cats2)
    copyList(animals1, cats2)
}