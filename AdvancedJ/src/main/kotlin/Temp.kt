fun main(args: Array<String>) {
    val str = "𝄞clef"
    for (c in str) {
        println(c)
    } //=> ? ? c l e f
    println(str.length) //=>6
    println("- - - - - - - - - ")

    val charId = str.codePointAt(0)
    val achar = Character.toChars(charId)
    println(achar) //=> 𝄞
    println("- - - - - - - - - ")

    println(str.codePointCount(0, str.length)) //=> 5.  [begin, end)的范围
    for (i in 0 until str.length) {
        val codePoint = str.codePointAt(i)
        val theChar = Character.toChars(codePoint)
        println(theChar)
    } //=>  𝄞 ? c l e f
    println("- - - - - - - - - ")


    val len = str.length
    var i = 0
    while(i < len){
        val codePoint = str.codePointAt(i)
        val charLength = Character.charCount(codePoint)
        i += charLength
        val theChar = Character.toChars(codePoint)
        println(theChar)
    }//=>  𝄞 c l e f

}