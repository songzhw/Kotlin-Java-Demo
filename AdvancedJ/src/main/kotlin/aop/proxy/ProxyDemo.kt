package aop.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

// 函数无入参时
interface IClickListener {
    fun onClick()
}

class ButtonClickListener : IClickListener {
    override fun onClick() {
        println("szw click button")
    }
}

class TraceHelper(val listener: IClickListener) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {
        println("szw before click")
        println("$args, ${args?.size}") //=> onClick()这样没有入参的情况下, args是null. 所以反射时要注意, 得传一个空Array进去才行
        if (args == null) {
            method?.invoke(listener)  // method?.invoker(listener, *arrayOf())也是行的
        } else {
            method?.invoke(listener, *args)
        }
        println("szw trace.track click event")
        return Unit
    }
}


fun main(args: Array<String>) {
    val listener: IClickListener = ButtonClickListener()
    val tracedListener = TraceHelper(listener)

    val classLoader = IClickListener::class.java.classLoader
    val proxyed: IClickListener =
            Proxy.newProxyInstance(
                    classLoader,
                    arrayOf<Class<*>>(IClickListener::class.java),
                    tracedListener
            ) as IClickListener

    proxyed.onClick()
}


// 带参数时
//interface IClickListener {
//    fun onClick(view: String)
//}
//
//class ButtonClickListener : IClickListener {
//    override fun onClick(view: String) {
//        println("I clicked $view")
//    }
//
//}
//
//class TraceHelper(private val target: IClickListener) : InvocationHandler {
//
//    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any? {
//        println("before print")
//        method.invoke(target, *args)  // 不加*, 就会有错: IllegalArgumentException: argument type mismatch
//        println("after print")
//        return null
//    }
//
//}
//
//fun main(args: Array<String>) {
//    val wrapped = Proxy.newProxyInstance(
//            IClickListener::class.java.classLoader,
//            arrayOf<Class<*>>(IClickListener::class.java),
//            TraceHelper(ButtonClickListener())
//    ) as IClickListener
//    wrapped.onClick("TextView")
//}