package ca.six.algo.string

fun originalReplaceWhitespace(str: Array<Char>) {
//    for (char in str) {
//        if (char == ' ') {
//            // index
//            for(i = index+2; index <= length + 2; index++){
//                str[i] = str[index]
//            }
//        }
//    }
}

// 时间复杂度是O(n) + O(n) = O(n)
fun replaceWhitespace(str: CharArray) {
    var spaceCount = 0
    for (char in str) {
        if (char == ' ') spaceCount++
    }

    val sizeBefore = str.size
    val sizeAfter = sizeBefore + spaceCount * 2 // " "要换成"%20", 即每个空格的长度增加了2
    var p2 = sizeAfter - 1

    // 原来的str长度写死了, 不另写一个ret, 就会越界的!
    val ret = CharArray(sizeAfter)
    for (i in sizeBefore - 1 downTo 0) {
        val char = str[i]
        if (char == ' ') {
            ret[p2] = '0'
            ret[p2 - 1] = '2'
            ret[p2 - 2] = '%'
            p2 -= 3
        } else {
            ret[p2] = char
            p2--
        }
    }

    println(ret)
}

fun main() {
    replaceWhitespace("welcome to here".toCharArray())
}