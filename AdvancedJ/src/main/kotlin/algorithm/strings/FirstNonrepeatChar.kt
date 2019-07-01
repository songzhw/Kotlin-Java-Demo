package algorithm.strings

fun findFirstNonRepeatedChar(str: String): String {
    val map = hashMapOf<String, Int>()
    // for (c in str) {  // c只是一个字符, 但有时需要2个char来表示一个Utf-16字符(code point). 所以这种for-each不能用了
    val len = str.codePointCount(0, str.length)
    var i = 0
    while (i < len) {
        val codePoint = str.codePointAt(i)
        val charLength = Character.charCount(codePoint)
        i += charLength
        val theChar = Character.toChars(codePoint)
        val key = String(theChar)

        val count = if (map.get(key) != null) map.get(key) else 0;
        val newCount = count!! + 1
        map.set(key, newCount)
    }

    i = 0
    while (i < len) {
        val codePoint = str.codePointAt(i)
        val charLength = Character.charCount(codePoint)
        i += charLength
        val theChar = Character.toChars(codePoint)
        val key = String(theChar)

        val count = map.get(key)
        if (count == 1) {
            return key
        }
    }

    return ""
}

fun main() {
    val num = findFirstNonRepeatedChar("water apple tip work")
    println(num) //=> l
}