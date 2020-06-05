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

fun replaceWhitespace(str: CharArray) {
    var spaceCount = 0
    for(char in str){
        if(char == ' ') spaceCount++
    }

    val sizeBefore = str.size
    val sizeAfter = sizeBefore + spaceCount * 2 // " "要换成"%20", 即每个空格的长度增加了2
    val p1 = sizeBefore - 1
    val p2 = sizeAfter - 2

    // 原来的str长度写死了, 不另写一个ret, 就会越界的!
    val ret = CharArray(sizeAfter)
    var index = 0
//    for(char in str){
//        ret.set(index, char)
//        index++
//    }




    println(ret)


}

fun main() {
    replaceWhitespace("welcome to here".toCharArray())
}