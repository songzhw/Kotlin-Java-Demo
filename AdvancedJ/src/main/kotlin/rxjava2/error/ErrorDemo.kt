package rxjava2.error


fun main(args: Array<String>) {
    var i = 1
    val http = HttpEngine()
    http.getStory_E()
            .subscribe{ value -> println("${i++}.$value")}
}