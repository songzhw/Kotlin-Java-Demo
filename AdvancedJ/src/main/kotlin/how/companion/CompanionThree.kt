package how.companion

abstract class Provider<T>{
    var mocked : T? = null

    fun get(): T = mocked ?: create()

    abstract fun create() : T
}

interface IFlagRepository {
    fun getFlag() : String
    companion object : Provider<IFlagRepository>(){
        override fun create() = FlagRepositoryImpl()
    }
}

class FlagRepositoryImpl : IFlagRepository {
    override fun getFlag(): String {
        return "basketball"
    }
}

class MockedFlagRepository : IFlagRepository {
    override fun getFlag(): String {
        return "mocked"
    }

}

fun main(args: Array<String>) {
    IFlagRepository.mocked = MockedFlagRepository()
    val flag = IFlagRepository.get()
    println("szw $flag")  //=> szw how.companion.MockedFlagRepository@372f7a8d

    IFlagRepository.mocked = null
    val flag2 = IFlagRepository.get()
    println("szw $flag2") //=> szw how.companion.FlagRepositoryImpl@2f92e0f4
}