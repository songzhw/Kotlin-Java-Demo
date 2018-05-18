package ca.six.practice

import java.net.URL
import java.util.*


class SearchResult(val url: String, val score: Int, val timeStamp: Long) {
}

interface SearchModel {
    fun load(url: String, timestamp: Date, isOpenTab: Boolean)
    fun search(query: String): List<SearchResult>
}

class UrlItem(val url: String, val host: String, val path: String, val timeStamp: Long, val isOpenTab: Boolean) {
}

// Mock a database
//val database: HashMap<String, UrlItem> = HashMap()
val database: ArrayList<UrlItem> = ArrayList()

class SimpleSearchModel : SearchModel {
    override fun load(url: String, timestamp: Date, isOpenTab: Boolean) {
        val urlObject = URL(url)
        database.add(UrlItem(url, urlObject.host, urlObject.path, timestamp.time, isOpenTab))
    }

    override fun search(query: String): List<SearchResult> {
        val searchResults: ArrayList<SearchResult> = ArrayList()

        val keywords = query.split(" ")
        database.forEach nextUrlItem@ { urlItem ->
            var score = 0
            keywords.forEach { keyword ->
                var scoreInThisKeyword = 0
                val url = urlItem.url

                // calculate the score
                if (keyword == urlItem.host) {
                    scoreInThisKeyword += 50
                } else if (urlItem.host.contains(keyword)) {
                    scoreInThisKeyword += 25
                }

                if (urlItem.path.contains(keyword)) {
                    scoreInThisKeyword += 10
                }

                // if no match, move on to next urlItem;
                if (scoreInThisKeyword == 0) {
                    return@nextUrlItem
                } else {
                    score += scoreInThisKeyword
                }
            }


            if (urlItem.isOpenTab) {
                score += 250
            }


            // every query item is matched, then add it to the searchResult
            val result = SearchResult(urlItem.url, score, urlItem.timeStamp)
            searchResults.add(result)
        }

        // only get five
        // order alphabetically
        val optimizedResults = searchResults
                .sortedWith(kotlin.Comparator<SearchResult> { result1, result2 ->
                    if (result2.score == result1.score) {
                        result2.timeStamp.compareTo(result1.timeStamp)
                    } else {
                        result2.score.compareTo(result1.score)
                    }
                })
                .take(5)

        return optimizedResults
    }

}


fun main(args: Array<String>) {
    val searchModel = SimpleSearchModel()
    val raw = arrayOf(
            "https://www.youtube.com/watch?v=dC9vdQkU-xI",
            "https://arxiv.org/abs/1804.07612",
            "https://medium.com/bings/blog/ruby-introduction/",
            "https://medium.com/running-rails-on-aws-elastic-beanstalk-con",
            "https://medium.com/@pavisj/convolutions-and-backpropagations-46026a8f5d2c",
            "https://www.youtube.com/watch?v=BMHUKij1yUE",
            "http://semantic-domain.blogspot.com/2018/04/are-functional-programs-easier-to.html"
    )

    var timestamp = 347237L
    for (url in raw) {
        searchModel.load(url, Date(timestamp), url.contains("ruby"))
        timestamp += 1500
    }

    val queryKeyWords = readLine()
    val results = searchModel.search(queryKeyWords!!)
    for (result in results) {
        println("${result.score}  ${result.url}")
    }
}