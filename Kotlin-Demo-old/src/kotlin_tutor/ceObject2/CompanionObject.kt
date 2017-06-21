package cn.song.ceObject2

/**
 * Created by hzsongzhengwang on 2015/9/18.
 */

// companion object is like "static" in java

//1.
class Onex{
    companion object bing{
        fun getInstance() : Onex = Onex()
    }

//    companion object{  } //Error! only one companion class is allowed!!!
}

class Oney{
    //2. the name of the companion object can be omitted,
    // in which case the name "Companion" will be used (in line 31 "var x = Oney.Companion")
    companion object{
        fun create() : Oney = Oney()
    }
}

// 3.
interface ITest<T>{
    fun test() : T
}
class Onez{
    companion object : ITest<Onez>{
        override fun test(): Onez  = Onez()
    }
}

fun testCO() {
    // memebers of the companion object can be called by using simply the class name as the qualifier
    val instance = Onex.getInstance()

    val obj2 = Oney.create()
    val x = Oney.Companion


}