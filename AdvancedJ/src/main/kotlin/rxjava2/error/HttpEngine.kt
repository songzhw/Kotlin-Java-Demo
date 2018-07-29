package rxjava2.error

import io.reactivex.Observable
import pojo.StoryResponse

class HttpEngine {
    fun getStory(): Observable<StoryResponse> {
        val json = """
            {
              "code": 1000,
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
              "code": 200,
              "desp": "database issue",
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