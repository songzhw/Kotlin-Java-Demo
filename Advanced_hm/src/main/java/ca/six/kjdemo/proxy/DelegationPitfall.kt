package ca.six.kjdemo.proxy

interface IDelegatePitfall {
    val id: String
    val name: String
    fun print()
    fun foo();
}

class DelegationPitfallImpl : IDelegatePitfall {
    override val id = "biz"
    override val name ="bizName"
    override fun print() { println(id) }
    override fun foo() { println(id) }
}

class Wrapper(biz: IDelegatePitfall) : IDelegatePitfall by biz{
    override val id = "wrapper"

    override fun foo() {
        println(id)
    }
}

fun main() {
    val obj = Wrapper(DelegationPitfallImpl())
    obj.print() //=> biz (注意,这里不是wrapper!!!  因为wrapper没有覆写print, 所以print里调用的仍是biz里的id对象)
    println(obj.name) //=> bizName
    obj.foo()   //=> wrapper (因为wrapper自己override了foo, 所以是使用自己的member)
}