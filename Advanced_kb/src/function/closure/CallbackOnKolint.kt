package function.closure

internal fun callA(listener: ICallbackOnJava){
    listener.callJava("AAA")
}

fun main() {
    val javaObj = CallbackOnJava()
    javaObj.call("hello") { name ->
        20  // 和下面的object: ICallbackOnJava2对比下, 它是不能有return的, 不然会报错.
    }

    // = = = = = = = = = = = = = = = = = = = =

    // ERROR: because the ICallbackOnJava2 interface has two functions (not one!!!)
//    javaObj.call2A("2A") { name ->
//        30
//    }

    javaObj.call2A("2A", object : ICallbackOnJava2 {
        override fun callJava2A(id: String?): Int {
            return 30
        }

        override fun callJava2B(id: String?): Int {
            return 10
        }

    })

}