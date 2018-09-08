package rxjava2

import io.reactivex.Flowable
import io.reactivex.Observable

class HttpEngine {
    fun getItemDetail(): Flowable<String> {
        Thread.sleep(2000)
        val ret = Flowable.just("from server")
        return ret
    }
}