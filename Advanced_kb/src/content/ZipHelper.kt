package content

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream


object ZipHelper {
    fun createZipFile(sourceFilePath: String, targetPath: String?, zipFileName: String): Boolean {

        var flag = false
        var fos: FileOutputStream? = null
        var zos: ZipOutputStream? = null

        // 要压缩的文件资源
        val sourceFile = File(sourceFilePath)
        // zip文件存放路径
        var zipPath = ""

        if (null != targetPath && "" != targetPath) {
            zipPath = targetPath + File.separator + zipFileName
        } else {
            zipPath = File(sourceFilePath).parent + File.separator + zipFileName
        }

        if (sourceFile.exists() == false) {
            println("待压缩的文件目录：" + sourceFilePath + "不存在.")
            return flag
        }

        try {
            val zipFile = File(zipPath)
            if (zipFile.exists()) {
                println(zipPath + "目录下存在名字为:" + zipFileName + ".zip" + "打包文件.")
            } else {
                val sourceFiles = sourceFile.listFiles()
                if (null == sourceFiles || sourceFiles.size < 1) {
                    println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.")
                } else {
                    fos = FileOutputStream(zipPath)
                    zos = ZipOutputStream(BufferedOutputStream(fos))
                    // 生成压缩文件
                    writeZip(sourceFile, "", zos)
                    flag = true
                }
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            //关闭流
            try {
                zos?.close()
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        return flag
    }

    private fun writeZip(file: File, parentPath: String, zos: ZipOutputStream) {
        var parentPath = parentPath
        if (file.exists()) {
            // 处理文件夹
            if (file.isDirectory) {
                parentPath += file.name + File.separator
                val files = file.listFiles()
                if (files!!.size != 0) {
                    for (f in files) {
                        // 递归调用
                        writeZip(f, parentPath, zos)
                    }
                } else {
                    // 空目录则创建当前目录的ZipEntry
                    try {
                        zos.putNextEntry(ZipEntry(parentPath))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            } else {
                var fis: FileInputStream? = null
                try {
                    fis = FileInputStream(file)
                    val ze = ZipEntry(parentPath + file.name)
                    zos.putNextEntry(ze)
                    val content = ByteArray(1024)
                    var len: Int = fis.read(content)
                    while (len != -1) {
                        zos.write(content, 0, len)
                        zos.flush()
                        len = fis.read(content)
                    }
                } catch (e: FileNotFoundException) {
                    println("创建ZIP文件失败$e")
                } catch (e: IOException) {
                    println("创建ZIP文件失败$e")
                } finally {
                    try {
                        fis?.close()
                    } catch (e: IOException) {
                        println("创建ZIP文件失败$e")
                    }

                }
            }
        }
    }


}

fun main() {
    val fromFolder = "/Users/zsong/temp/epub_reader/html_unzipped"
    val toFile = "/Users/zsong/temp/epub_reader"
    ZipHelper.createZipFile(fromFolder, toFile, "mine.epub")
}