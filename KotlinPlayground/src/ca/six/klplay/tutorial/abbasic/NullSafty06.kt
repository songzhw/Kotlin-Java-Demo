package cn.song.abbasic

/**
 * Created by hzsongzhengwang on 2015/8/21.
 */
fun nullSafe(args: Array<String>) {
    var a : String = "abc"
//    a = null // Error!

    var b : String? = "abc"
    b = null  // OK

    println(a.length)
//    println(b.length())// Error!



    //two way to do the "b.length()", and compiler doesn't complain
    // 1.
    val len1 = if(b != null) b.length else -1

    //2.
    val len2 = b?.length //This returns b.length() if b is not null, and null otherwise. The type of this expression is Int?.
    val len3 = b?.length ?: -1 //效果赞同于 if(b != null) b.length() else -1



    // elvis operator
    /*
    fun foo(node: Node): String? {
        val parent = node.getParent() ?: return null
        val name = node.getName() ?: throw IllegalArgumentException("name expected")
        // ...
    }
    */


    // "!!" operator
    val len4 = b!!.length // return a non-null value of b or throw an NPE if b is null

    // safe cast： "as?" returns null on failure, rather than throws an exception
    val aint : Int? = a as? Int


    println("b?.length = "+b?.length)    //=> 3
    println("b!!.length = "+b!!.length) //=> crash: KotlinNullPointerException

}

fun main(args: Array<String>) {
    nullSafe(arrayOf("a"))
}