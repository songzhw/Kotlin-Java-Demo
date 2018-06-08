package aop.proxy.retrofit.Demo

import aop.proxy.retrofit.Call
import aop.proxy.retrofit.GET
import aop.proxy.retrofit.Retrofit

interface HttpApi {
    @GET("users")
    fun getUsers(): Call<List<User>>
}

fun main(args: Array<String>) {
    val retrofit = Retrofit("http://api.songzhw.ca")
    val http: HttpApi = retrofit.create(HttpApi::class.java)
    val users = http.getUsers()
}