package content

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

fun main() {
    val from = "/Users/zsong/temp/epub_reader/html_unzipped"
    val to = "/Users/zsong/temp/epub_reader/t25.zip"
    addFolderToZip(from, to)
}

fun addFolderToZip(folder: String, destination: String) {
    val folderToZip = File(folder)
    var out: ZipOutputStream? = null
    try {
        out = ZipOutputStream(BufferedOutputStream(FileOutputStream(destination)))
        recursivelyAddZipEntries(folderToZip, folderToZip.absolutePath, out)
    } catch (e: Exception) {
        println("ZIP Err " + e.message)
    } finally {
        out?.close()
    }
}

private fun recursivelyAddZipEntries(
    folder: File,
    basePath: String,
    out: ZipOutputStream
) {

    val files = folder.listFiles() ?: return
    for (file in files) {

        if (file.isDirectory) {
            recursivelyAddZipEntries(file, basePath, out)
        } else {
            val origin = BufferedInputStream(FileInputStream(file))
            origin.use {
                var entryName = file.path.substring(basePath.length + 1)
                out.putNextEntry(ZipEntry(entryName))
                origin.copyTo(out, 1024)
            }
        }

    }

}