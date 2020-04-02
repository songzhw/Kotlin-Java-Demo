package ca.six.kjdemo.proxy

interface IDelegatePitfall {
    val id: String
    fun print()
}

class DelegationPitfallImpl : IDelegatePitfall {
    override val id = "biz"
    override fun print() { print(id) }
}

class Wrapper(biz: IDelegatePitfall) : IDelegatePitfall by biz{
    override val id = "wrapper"
}

fun main() {
    val obj = Wrapper(DelegationPitfallImpl())
    obj.print() //=> biz (注意,这里不是wrapper!!!)
}