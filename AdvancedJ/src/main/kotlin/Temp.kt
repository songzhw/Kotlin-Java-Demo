import java.net.URL

fun main(args: Array<String>) {
    val url = "https://us-central1-fbdemo-fa57b.cloudfunctions.net/beginVote"
    URL(url).openStream().use { instream ->

    }
}