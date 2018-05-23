package ca.six.kex.generics

class SongKt<T>(val helper: T) {

    // 泛型方法
    fun <R> transform(t: T, r: R): R {
        return r
    }

}