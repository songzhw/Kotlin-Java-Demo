package rxjava2.error

import io.reactivex.Observable
import pojo.StoryResponse

val SUCCESS_RESP = 1000
val DATABASE_ERROR = 200
val SESSION_TIMEOUT = 300

class HttpEngine {
    fun getStory(): Observable<StoryResponse> {
        val json = """
            {
              "code": $SUCCESS_RESP,
              "desp": "okay",
              "data": {
                    "id": 123,
                    "content": "long long time ago"
              }
            }
        """
        val resp = StoryResponse(json)
        return Observable.just(resp)
    }


    fun getStory_dbWrong() : Observable<StoryResponse> {
        val json = """
            {
              "code": $DATABASE_ERROR,
              "desp": "database issue",
              "data": {
              }
            }
        """
        val resp = StoryResponse(json)
        return Observable.just(resp)
    }

    fun getStory_timeout() : Observable<StoryResponse> {
        val json = """
            {
              "code": $SESSION_TIMEOUT,
              "desp": "session time out, please log in again",
              "data": {
              }
            }
        """
        val resp = StoryResponse(json)
        return Observable.just(resp)
    }



    fun getStory_E() : Observable<String>{
        return Observable.error(Exception("test"))
    }

    fun getStoryList(): Observable<List<String>> {
        val list = arrayOf("One", "Two", "Three", "Four", "Five").asList()
        return Observable.just(list)
    }
}