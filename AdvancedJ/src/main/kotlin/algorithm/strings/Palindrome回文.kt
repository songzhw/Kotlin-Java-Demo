package algorithm.strings

fun palindrome(str: String): Boolean {
    val len = str.length
    for (i in 0 until len) {  //[0, len)  || for (i in 0..len)则是[0, len]
        if (str[i] != str[len - 1 - i]) {
            return false
        }
    }
    return true
}

fun main() {
    println(palindrome("madam"))
    println(palindrome("test"))
    println(palindrome("我爱我"))
    println(palindrome("woow"))
}