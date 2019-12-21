package ca.six.kjdemo.mutual.kt

class OneData(val id: Int, var name: String)
//=> 生成两个private成员, getId(), getName(), setName()方法

class TwoData(@JvmField val id: Int, @JvmField var name: String)
//=> 这样子就只有public成员, 不再有getter(), setter()