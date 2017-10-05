package ca.six.klplay.okhttp.download

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import java.io.IOException
import sun.security.krb5.Confounder.bytes
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import okio.Okio
import okio.BufferedSink
import java.io.File

fun downloadPic() {

    val request = Request.Builder()
            .url("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2859174087,963187950&fm=23&gp=0.jpg")
            .build()

    val http = OkHttpClient.Builder().build()

    val response = http.newCall(request).execute()

    val downloadedFile = File("E:/tmp/test.jpg")
    if(!downloadedFile.exists()){
        downloadedFile.createNewFile()
    }
    val sink = Okio.buffer(Okio.sink(downloadedFile))
    sink.writeAll(response.body()!!.source())
    sink.close()
}

fun main(args: Array<String>) {
    downloadPic()
}