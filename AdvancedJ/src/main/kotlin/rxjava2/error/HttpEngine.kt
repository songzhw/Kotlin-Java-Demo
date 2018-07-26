package rxjava2.error

import io.reactivex.Observable

class HttpEngine {
    fun getStoryList(): Observable<List<String>> {
        val list = arrayOf("One", "Two", "Three", "Four", "Five").asList()
        return Observable.just(list)
    }

    fun getStory_E() : Observable<String>{
        return Observable.error(Exception("test"))
    }
}