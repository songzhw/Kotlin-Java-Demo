package cn.song.caextension

/**
 * Created by hzsongzhengwang on 2015/9/10.
 */

// IntArray has no a method named "swap2". So this is an extension.
fun IntArray.swap2(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun testExtension(){

    // ============== 1. intro ==============
    // 声明方式是：“类名.扩展方法名()”

    val list = intArrayOf(1,2,3,4,5)
    list.swap2(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
    list.forEach { print(" ${it}") }  //=> 3 2 1 4 5
    println(" \n ")


    //==============2. Extensions are resolved statically==============
    class CA{
        fun foo() { println("member")}
    }

    fun CA.foo() {println("extension")}

    var ca = CA()
//    CA.foo() // error! "Unresolved reference : foo"
    ca.foo()  //=>  member

    // memo:
    // 1. Monkey Patch in Kotlin is only for object to use(?), so Line 31 will be an error
    // 2.extensions are resolved statically

    //============== 3. Extension Properties ==============



    //==============  ==============
}


//fun main(args: Array<String>) {
//    testExtension()
//}