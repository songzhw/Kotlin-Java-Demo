package generics

class IsEqual<in T> {
    fun isEqual(other: T): Boolean {
        return false
    }
}

// Double的父类是Number, Comparable
fun main() {
    val obj = IsEqual<Number>();
    val another : IsEqual<Double> = obj;
}