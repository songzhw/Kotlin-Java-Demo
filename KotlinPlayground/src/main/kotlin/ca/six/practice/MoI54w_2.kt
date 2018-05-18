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
                if (keyword.equals(url)) {
                    scoreInThisKeyword += 50
                } else if (url.contains(keyword)) {
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
                    result2.score.compareTo(result1.score)
                })
                .take(5)

        return optimizedResults
    }

}