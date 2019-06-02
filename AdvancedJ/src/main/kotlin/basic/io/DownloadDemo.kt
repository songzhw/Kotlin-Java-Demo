package basic.io

import java.io.IOException
import java.io.InputStream
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.io.File
import java.net.URL
import java.nio.channels.Channels
import java.nio.channels.FileChannel
import java.nio.channels.ReadableByteChannel


fun download1_stream(url: String, saveDir: String, fileName: String) {
    var bos: BufferedOutputStream? = null
    var instream: InputStream? = null
    try {
        val buff = ByteArray(8192)
        instream = URL(url).openStream()
        val file = File(saveDir, fileName)
        file.parentFile.mkdirs()
        bos = BufferedOutputStream(FileOutputStream(file))
        var count = instream.read(buff)
        while (count != -1) {
            bos.write(buff, 0, count)
            count = instream.read(buff)
        }
    } finally {
        instream?.close()
        bos?.close()
    }

}



fun main() {
    val url = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
    download1_stream(url, ".", "g1.png")
}
