package rxjava2

object HttpEngine {
    fun getItemDetail(callback: HttpCallback<String>) {
        Thread(Runnable {
            Thread.sleep(2000)
            callback.onSucc("from server")
        }).start()
    }
}

interface HttpCallback<T> {
    fun onSucc(t: T)
}