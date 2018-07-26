package rxjava2.error


fun main(args: Array<String>) {
    var i = 1
    val http = HttpEngine()
    http.getStoryList()
            .subscribe{ value : String -> println("${i++}.$value")}
}