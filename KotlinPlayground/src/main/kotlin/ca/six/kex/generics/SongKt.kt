package ca.six.kex.generics

import ca.six.jold.generics.Apple
import ca.six.jold.generics.Fruit
import java.util.ArrayList

class SongKt<T>(val helper: T) {

    // 泛型方法
    fun <R> transform(t: T, r: R): R {
        return r
    }

    fun cast(){
        val apples = ArrayList<Apple>()
        val fruits : List<Fruit> = apples

    }

    private fun subtypes(sub: List<Fruit>): List<Fruit> {
        val all = ArrayList<Fruit>()
        all.addAll(sub)
        return all
    }

    // Error
    private fun superTypes(arg: List<in Fruit>) {

    }

}