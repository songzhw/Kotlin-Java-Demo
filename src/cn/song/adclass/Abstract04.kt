package cn.song.adclass

/**
 * Created by hzsongzhengwang on 2015/8/14.
 */

/*
A class and some of its members may be declared abstract.
An abstract member does not have an implementation in its class.
Thus, when some descendant inherits an abstract member,
it does not count as an implementation
*/
abstract class A2 {
    abstract fun f()
}

interface B2 {
    fun f() { print("B") } // interface members are 'open' by default
}

// We are not required to override f()
class C2() : A2(), B2 {
}

// must override f()
class C22() : A2(){
    override fun f() {}
}

// We are not required to override f()
class C23() : B2 {
}