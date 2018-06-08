package aop.proxy.retrofit

interface Call<T> {
    fun call(t: T)
}