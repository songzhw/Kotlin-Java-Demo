package ca.six.klplay.okhttp.download

import ca.six.daily.core.network.download.ProgressListener
import ca.six.daily.core.network.download.ProgressResponseBody
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import java.io.IOException
import sun.security.krb5.Confounder.bytes



fun downloadPic() {
    val request = Request.Builder()
            .url("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2859174087,963187950&fm=23&gp=0.jpg")
            .build()

    val listener = object : ProgressListener {
        override fun update(bytesRead: Long, contentLength: Long, isDone: Boolean) {
            println("szw progress : $bytesRead , $contentLength , $isDone")
            val percent: Int = (100 * bytesRead / contentLength).toInt()
            println("szw progress = $percent")
        }
    }

    val http = OkHttpClient.Builder().build()

    Observable.create<Response> { emitter ->
                val resp = http.newCall(request).execute()
                emitter.onNext(resp)
            }
            .map { rawResp ->
                ProgressResponseBody(rawResp.body()!!, listener)
            }
            .map { progressResp ->
                progressResp.bytes()
            }
            .subscribe {
                println("szw subscribe size = ${it.size}")
            }

}

fun main(args: Array<String>) {
    downloadPic()
}