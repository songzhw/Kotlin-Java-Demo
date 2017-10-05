package ca.six.klplay.advanced.delegation.lazy

//这里我们在java环境下模拟一个Activity类, 内有findViewById()方法,不过返回的是一个String了.
open class Activity{
    fun findViewById(id : Int) : String {
        return "textView"
    }
}



