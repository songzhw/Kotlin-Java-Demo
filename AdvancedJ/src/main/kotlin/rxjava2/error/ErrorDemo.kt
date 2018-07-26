package rxjava2.error

val DEFAULT_ERROR = 0

fun main(args: Array<String>) {
    var i = 1
    val http = HttpEngine()
    http.getStoryList()
            .map { 23/0 }
            .onErrorReturn { error ->
                println("szw error ${error}")
                DEFAULT_ERROR }
            .subscribe{ println("$it")}
}