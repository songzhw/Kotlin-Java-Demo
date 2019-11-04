package higher.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*

interface IUserService {
    fun select()
    fun update()
}

class UserServiceImpl : IUserService {
    override fun select() {
        System.out.println("查询 selectById");
    }

    override fun update() {
        System.out.println("更新 update");
    }
}


class LogProxy(internal var target: Any) : InvocationHandler {

    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any {
        before()
        val result = method.invoke(target, *args)  // 调用 target 的 method 方法
        after()
        return result  // 返回方法的执行结果
    }

    // 调用invoke方法之前执行
    private fun before() {
        println(String.format("log start time [%s] ", Date()))
    }

    // 调用invoke方法之后执行
    private fun after() {
        println(String.format("log end time [%s] ", Date()))
    }

}

fun main() {
    val worker = UserServiceImpl()
    val classLoader = worker.javaClass.classLoader
    val interfaces = worker.javaClass.interfaces
    val shadow = LogProxy(worker)
    val proxy = Proxy.newProxyInstance(classLoader, interfaces, shadow) as IUserService

    proxy.select()
    proxy.update()
}