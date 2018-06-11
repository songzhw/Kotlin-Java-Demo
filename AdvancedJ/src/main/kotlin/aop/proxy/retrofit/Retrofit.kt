package aop.proxy.retrofit

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
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
        println("http url = ${url}")

        val tmp = method.genericReturnType as ParameterizedType //=> Call<List<User>>; 有泛型时是Call<List<T>>
        val tmp2 = tmp.actualTypeArguments[0]
        if(tmp2 is ParameterizedTypeImpl) {
            // 有泛型时, 如Call<List<User>
            val returnedType = tmp2 as ParameterizedTypeImpl     //=> List<User>; 有泛型时是List<T>
            val clz = returnedType.rawType
            return clz.newInstance()
        } else {
            // 无泛型时, 如Call<User>
            val clz = tmp2 as Class<*>
            return clz.newInstance()
        }
    }

}