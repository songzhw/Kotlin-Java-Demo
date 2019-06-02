package basic.io

import java.io.InputStream
import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.io.File
import java.net.URL
import java.nio.channels.Channels
import java.nio.channels.FileChannel
import java.nio.channels.ReadableByteChannel
import java.io.IOException
import java.nio.file.StandardCopyOption
import java.nio.file.Files
import com.sun.org.apache.xerces.internal.util.DOMUtil.getParent
import java.nio.file.Paths


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

fun download2_NIO(url: String, saveDir: String, fileName: String) {
    var byteChannel: ReadableByteChannel? = null
    var fos: FileOutputStream? = null
    var fileChannel: FileChannel? = null
    try {
        byteChannel = Channels.newChannel(URL(url).openStream())
        val file = File(saveDir, fileName)
        file.parentFile.mkdirs()

        fos = FileOutputStream(file)
        fileChannel = fos.channel
        fileChannel.transferFrom(byteChannel, 0, java.lang.Long.MAX_VALUE)
    } finally {
        byteChannel?.close()
        fileChannel?.close()
    }
}

fun download_NIO2(url: String, saveDir: String, fileName: String) {
    // Kotlin的use:  会自动关闭调用者（无论中间是否出现异常）
    URL(url).openStream().use { ins ->
        val target = Paths.get(saveDir, fileName)
        Files.createDirectories(target.parent)
        Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING)

    }

}

fun main() {
    val url = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
    download_NIO2(url, ".", "g3.png")
}
