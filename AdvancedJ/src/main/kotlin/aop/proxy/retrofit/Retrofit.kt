package aop.proxy.retrofit

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
import java.lang.reflect.*

class Retrofit(val baseUrl: String) {
    fun <T> create(targetClass: Class<T>): T {
        val wrapped = Proxy.newProxyInstance(
                targetClass.classLoader,
                arrayOf<Class<*>>(targetClass),
                object : InvocationHandler {
                    override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any {

                        val getAnnotation = method.getAnnotation(GET::class.java)
                        val subUrl = getAnnotation.value
                        val url = "${baseUrl}/${subUrl}"
                        println("http url = ${url}")

                        // 若返回Call<User>, 那这没问题
                        // 若返回User, 那method.genericReturnType就是Class, 而不是ParametrizedType
                        val returnType = method.genericReturnType  //=> Call<List<User>>; 有泛型时是Call<List<T>>

                        if (returnType is ParameterizedType) {
                            val actualType = returnType.actualTypeArguments[0]
                            if (actualType is ParameterizedTypeImpl) {
                                // 有泛型时, 如Call<List<User>
                                val returnedType = actualType as ParameterizedTypeImpl     //=> List<User>; 有泛型时是List<T>
                                val clz = returnedType.rawType
                                return clz.newInstance()
                            } else {
                                // 无泛型时, 如Call<User>. clz就是User
                                val clz = actualType as Class<*>
                                val obj = clz.newInstance()
                                return obj  // TODO 返回List<User>时, 这里clz是User类, 但要如何转成List<User>?
                            }
                        } else {
                            // 返回的不是Call<User>, 而就是无泛型的, 如User
                            val clz = returnType as Class<*>
                            return clz.newInstance()
                        }
                    }

                }
        ) as T
        return wrapped
    }
}


