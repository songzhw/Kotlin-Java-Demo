package ca.six.kjdemo.proxy.kt

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


internal interface IService {
    fun getUser(id: Int): String
}

class DynamicProxyDemo {
    fun proxy(id: Int) {
        val handler =
            label@ InvocationHandler { proxy: Any?, method: Method, args: Array<Any> ->
                if (method.name == "getUser") {
                    return@label "user" + args[0]
                }
                null
            }
        val service = Proxy.newProxyInstance(
            IService::class.java.classLoader, arrayOf<Class<*>>(IService::class.java),
            handler
        ) as IService
        val ret = service.getUser(id)
        println(ret) //=> user20
    }

}

fun main(args: Array<String>) {
    val obj = DynamicProxyDemo()
    obj.proxy(20)
}
