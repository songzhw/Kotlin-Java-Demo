package rxjava2

import io.reactivex.Observable

class HttpEngine {
    fun getItemDetail(): Observable<String> {
        Thread.sleep(2000)
        val ret = Observable.just("from server")
        return ret
    }
}