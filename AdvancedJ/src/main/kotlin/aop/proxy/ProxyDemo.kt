package aop.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy


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
        if(args == null){
            method?.invoke(listener, *arrayOf()) //arrayOf()返回一个array. 要放入vararg中, 就得加个spread operator
        } else {
            method?.invoke(listener, *args)
        }
        println("szw trace.track click event")
        return Unit
    }
}


fun main(args: Array<String>) {
    val listener : IClickListener = ButtonClickListener()
    val tracedLIstener = TraceHelper(listener)

    val classLoader = IClickListener::class.java.classLoader
    val proxyed : IClickListener =
            Proxy.newProxyInstance(
                    classLoader,
                    arrayOf<Class<*>>(IClickListener::class.java),
                    tracedLIstener
            ) as IClickListener

    proxyed.onClick()
}


//
//interface IClickListener {
//    fun say(s: String)
//}
//
//class ButtonClickListener : IClickListener {
//    override fun say(s: String) {
//        println("hello $s")
//    }
//
//}
//
//class TraceHelper(private val target: IClickListener  // 原始对象
//) : InvocationHandler {
//
//    @Throws(Throwable::class)
//    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any? {
//        println("before print")
//        method.invoke(target, args)  // 不加*, 就会有错: IllegalArgumentException: argument type mismatch
//        println("after print")
//        return null
//    }
//
//}
//
//fun main(args: Array<String>) {
//    val hello = enhanceHello(ButtonClickListener())
//    hello.say("world")
//}
//
//fun enhanceHello(target: IClickListener): IClickListener {
//    return Proxy.newProxyInstance(
//            IClickListener::class.java.classLoader,
//            arrayOf<Class<*>>(IClickListener::class.java),
//            TraceHelper(target)
//    ) as IClickListener
//}



