package algorithm.strings

fun findFirstNonRepeatedChar(str: String): String {
    val map = hashMapOf<Int, Int>()
    // for (c in str) {  // c只是一个字符, 但有时需要2个char来表示一个Utf-16字符(code point). 所以这种for-each不能用了
    val len = str.codePointCount(0, str.length)
    for(i in 0..len){

    }
    return ""
}

fun main() {
    val num = findFirstNonRepeatedChar("water apple tip")
    println(num) //=> r
}