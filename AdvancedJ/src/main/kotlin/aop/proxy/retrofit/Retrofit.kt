package aop.proxy.retrofit

import aop.proxy.retrofit.Demo.HttpApi

class Retrofit(val baseUrl: String) {
    fun create(java: Class<out Any>): Any {

        return Unit
    }
}