package generics

class IsEqual<T> {
    fun isEqual(other: in T): Boolean {
        return false
    }
}

// Double的父类是Number, Comparable
fun main() {
    val obj = IsEqual<Number>();
    val another : IsEqual<Double> = obj;
}