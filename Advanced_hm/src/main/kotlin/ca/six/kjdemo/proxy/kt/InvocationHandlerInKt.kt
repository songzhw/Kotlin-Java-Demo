package ca.six.kjdemo.proxy.kt

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


internal interface IService {
    fun getUser(id: Int): String
}

class DynamicProxyDemo {
    fun proxy(id: Int) {
        val service = Proxy.newProxyInstance(
            IService::class.java.classLoader, arrayOf<Class<*>>(IService::class.java),
            object : InvocationHandler {
                override fun invoke(proxy: Any, method: Method, args: Array<out Any>): Any? {
                    if (method.name == "getUser") {
                        return "user" + args[0]
                    }
                    return null
                }

            }
        ) as IService
        val ret = service.getUser(id)
        println(ret) //=> user20
    }

}

fun main() {
    val obj = DynamicProxyDemo()
    obj.proxy(20) //=> user20
}
