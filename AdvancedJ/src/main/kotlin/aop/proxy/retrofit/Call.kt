package aop.proxy.retrofit

interface Call<T> {
    fun execute() : T
}