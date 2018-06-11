package aop.proxy.retrofit

import java.lang.reflect.*

class Retrofit(val baseUrl: String) {
    fun <T> create(targetClass: Class<T>): T {
        val wrapped = Proxy.newProxyInstance(
                targetClass.classLoader,
                arrayOf<Class<*>>(targetClass),
                HttpProxy(baseUrl)
        ) as T
        return wrapped
    }
}

/*
interface HttpApi {
    @GET("users")
    fun getUsers(): Call<List<User>>
}
 */
class HttpProxy(val baseUrl: String) : InvocationHandler {
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any {

        val getAnnotation = method.getAnnotation(GET::class.java)
        val subUrl = getAnnotation.value
        val url = "${baseUrl}/${subUrl}"

        // TODO when arguments is not null
        val tmp = method.genericReturnType as ParameterizedType //=> Call<List<User>>; 有泛型时是Call<List<T>>
        val returnedType = tmp.actualTypeArguments[0]      //=> List<User>; 有泛型时是List<T>
        println("${returnedType}}")
        return Unit
    }

}