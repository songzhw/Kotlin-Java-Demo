package aop.proxy.retrofit

import aop.proxy.retrofit.Demo.HttpApi

class Retrofit(val baseUrl: String) {
    fun <T> create(targetClass: Class<T>): T {
        return targetClass.newInstance()
    }
}