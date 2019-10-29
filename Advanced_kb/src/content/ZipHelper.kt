package content

import java.io.*
import java.util.zip.CRC32
import java.util.zip.CheckedOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream


object ZipHelper {
    val BUFFER = 8192

    @Throws(IOException::class)
    fun compress(srcPath: String, dstPath: String) {
        val srcFile = File(srcPath)
        val dstFile = File(dstPath)
        if (!srcFile.exists()) {
            throw FileNotFoundException(srcPath + "不存在！")
        }

        var out: FileOutputStream? = null
        var zipOut: ZipOutputStream? = null
        try {
            out = FileOutputStream(dstFile)
            val cos = CheckedOutputStream(out, CRC32())
            zipOut = ZipOutputStream(cos)
            val baseDir = ""
            compress(srcFile, zipOut, baseDir)
        } finally {
            if (null != zipOut) {
                zipOut.close()
                out = null
            }

            out?.close()
        }
    }

    @Throws(IOException::class)
    private fun compress(file: File, zipOut: ZipOutputStream, baseDir: String) {
        if (file.isDirectory) {
            compressDirectory(file, zipOut, baseDir)
        } else {
            compressFile(file, zipOut, baseDir)
        }
    }

    /** 压缩一个目录  */
    @Throws(IOException::class)
    private fun compressDirectory(dir: File, zipOut: ZipOutputStream, baseDir: String) {
        val files = dir.listFiles()
        for (i in files!!.indices) {
            compress(files[i], zipOut, baseDir + dir.name + "/")
        }
    }

    /** 压缩一个文件  */
    @Throws(IOException::class)
    private fun compressFile(file: File, zipOut: ZipOutputStream, baseDir: String) {
        if (!file.exists()) {
            return
        }

        var bis: BufferedInputStream? = null
        try {
            bis = BufferedInputStream(FileInputStream(file))
            val entry = ZipEntry(baseDir + file.name)
            zipOut.putNextEntry(entry)
            val data = ByteArray(BUFFER)
            var count: Int = bis.read(data, 0, BUFFER)

            while (count != -1) {
                zipOut.write(data, 0, count)
                count = bis.read(data, 0, BUFFER)
            }

        } finally {
            bis?.close()
        }
    }


}

fun main() {
    val fromFolder = "/Users/zsong/temp/epub_reader/html_unzipped"
    val toFile = "/Users/zsong/temp/epub_reader/two.zip"
    ZipHelper.compress(fromFolder, toFile)
}