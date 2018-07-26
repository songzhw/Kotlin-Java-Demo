package rxjava2.error

import io.reactivex.Observable

class HttpEngine {
    fun getStoryList(): Observable<String> {
        val list = arrayOf("One", "Two", "Three", "Four", "Five")
        return Observable.fromArray(*list)
    }
}