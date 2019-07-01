package algorithm.strings

fun findFirstNonRepeatedChar(str: String): CharArray {
    val map = hashMapOf<CharArray, Int>()
    // for (c in str) {  // c只是一个字符, 但有时需要2个char来表示一个Utf-16字符(code point). 所以这种for-each不能用了
    val len = str.codePointCount(0, str.length)
    var i = 0
    while (i < len) {
        val codePoint = str.codePointAt(i)
        val charLength = Character.charCount(codePoint)
        i += charLength
        val theChar = Character.toChars(codePoint)

        val count = if (map.get(theChar) != null) map.get(theChar) else 0;
        val newCount = count!! + 1
        map.set(theChar, newCount)
    }

    i = 0
    while (i < len) {
        val codePoint = str.codePointAt(i)
        val charLength = Character.charCount(codePoint)
        i += charLength
        val theChar = Character.toChars(codePoint)

        val count = map.get(theChar)
        println("${theChar} : $count")
        if (count == 1) {
            return theChar
        }
    }

    return "".toCharArray()
}

fun main() {
    val num = findFirstNonRepeatedChar("water apple tip")
    println(num) //=> r
}