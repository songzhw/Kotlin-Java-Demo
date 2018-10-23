import io.reactivex.Observable

val FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000
val FLAG_ACTIVITY_CLEAR_TOP = 0x04000000
val FLAG_ACTIVITY_SINGLE_TOP = 0x20000000

fun main(args: Array<String>) {
    var urlString = "http://a.com/b/z.epub"
    if (urlString.startsWith("http://")) {
        urlString = "https" + urlString.substring("http".length)
    }
    println("szw : url = $urlString")

    val ret1 = FLAG_ACTIVITY_CLEAR_TOP or FLAG_ACTIVITY_SINGLE_TOP
    println("szw ${ret1.toString(16)}")
    println("szw ${FLAG_ACTIVITY_REORDER_TO_FRONT.toString(16)}")
    println("szw ${ret1 == FLAG_ACTIVITY_REORDER_TO_FRONT}")


}