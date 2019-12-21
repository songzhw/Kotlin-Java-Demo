@file:JvmName("MyData")
package ca.six.kjdemo.mutual.kt

const val first = 1

class OneData(val id: Int, var name: String)
//=> 生成两个private成员, getId(), getName(), setName()方法

class TwoData(@JvmField val id: Int, @JvmField var name: String)
//=> 这样子就只有public成员, 不再有getter(), setter()

class DataThree(@JvmField val id: Int, @JvmField var name: String){
    lateinit var description: String
}
//=> description这个lateinit var变量也被生成了getter, setter
//=> 但注意, @JvmField不能用于lateinit var

class DataFour{
    companion object {
        const val id = 10;
    }
}