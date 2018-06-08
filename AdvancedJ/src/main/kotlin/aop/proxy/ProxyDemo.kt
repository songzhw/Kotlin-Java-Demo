package aop.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

// 函数无入参时
interface IClickListener {
    fun onClick()
}

// 函数有入参, 有返回值时
interface IRvItemClickListener {
    fun onClickItemAt(position: Int): Boolean
}

// 有泛型时
interface ISwipeListener {
    fun <T> onSwipe(t : T) : T
}

class ButtonClickListener : IClickListener {
    override fun onClick() {
        println("szw click button")
    }
}

class SwipeListener : ISwipeListener {
    override fun <T> onSwipe(t : T): T {
        println("swipe $t")
        return t
    }
}

class TraceHelper(val listener: Any) : InvocationHandler {
    var result: Any? = null  // 返回void的函数, 如void onClick(), method.invoke()返回的是Null, 所以这里要设置为Any?

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
        println("szw before click")  // proxy参数是"com.sun.proxy.$Proxy0"类型

        if (args == null) {
            result = method.invoke(listener)  // method?.invoker(listener, *arrayOf())也是行的
        } else {
            result = method.invoke(listener, *args)
        }

        println("szw trace.track click event")

        return result  //这个就是函数返回值. 若这里return Unit, 而实际方法是返回bool, 那就会有crash: ClassCastException: kotlin.Unit cannot be cast to java.lang.Boolean
    }
}


fun main(args: Array<String>) {
    // =================== View Click ===================
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

    // =================== RvItemClick ===================
    println("=================== =================== ")
    val itemListener = object : IRvItemClickListener {
        override fun onClickItemAt(position: Int): Boolean {
            println("click item $position")
            return false
        }
    }
    val traced2 = TraceHelper(itemListener)
    val proxyed2: IRvItemClickListener =
            Proxy.newProxyInstance(
                    classLoader,
                    arrayOf<Class<*>>(IRvItemClickListener::class.java),
                    traced2
            ) as IRvItemClickListener
    val ret2 = proxyed2.onClickItemAt(23)
    println("ret2 = $ret2")

    // =================== Swipe ===================
    println("=================== =================== ")
    val swipeListener = SwipeListener()
    val traced3 = TraceHelper(swipeListener)
    val proxyed3: ISwipeListener =
            Proxy.newProxyInstance(
                    classLoader,
                    arrayOf<Class<*>>(ISwipeListener::class.java),
                    traced3
            ) as ISwipeListener
    proxyed3.onSwipe("test")
}

