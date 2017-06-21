package cn.song.adclass

/**
 * Created by hzsongzhengwang on 2015/8/14.
 */

// "open" and "override" for the function
open class Base {
    open fun v() {}
    fun nv() {}
}

open class Derived() : Base() {
    //A member marked override is itself open,
    override fun v() {}
}

//------------------------------------------

class THirdDerived() : Derived() {
    override fun v() {}
}

//------------------------------------------

//A member marked override is itself open, it may be overridden in subclasses
// If you want to prohibit re-overriding, use final:
open class AnotherDerived() : Base() {
    final override fun v() {}
}