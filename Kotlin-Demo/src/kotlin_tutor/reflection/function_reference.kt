package kotlin_tutor.reflection

/**
 * Created by songzhw on 2016/2/17.
 */

fun main(args: Array<String>) {

    // 1. Function References : To pass a named function as a value, we use "::" operator
    fun isOdd(x : Int) = (x % 2 != 0)
    val numbers = listOf<Int>(1, 2, 3)
    println(numbers.filter(::isOdd)) //=> [1, 3]

    // 2. example : Function composition
    fun <A,B,C> compose(f : (B)-> C, g : (A)->B) : (A)->C {
        return { x-> f(g(x))}
    }

    fun len(s : String) = s.length
    val oddLen = compose(::isOdd, ::len)

    val strs = listOf<String>("a","ab","abc","abcd","abcde")
    println(strs.filter(oddLen))  //=> [a, abc, abcde]

}

