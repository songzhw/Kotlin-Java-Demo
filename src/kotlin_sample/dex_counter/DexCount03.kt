package kotlin_sample.dex_counter

import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipFile
import java.util.zip.ZipInputStream

/**
 * Created by songzhw on 2016/2/14.
 */


fun main(args: Array<String>) {
    var sample = DexCount03()
    sample.testZip()
    println("-------------------------")
    sample.testZip2()
}

class DexCount03 {
    fun testZip() {
        var bytes : List<ByteArray> = arrayListOf("test3.zip")
                .map { FileInputStream(File (it.toString())) }
                .map { it.readBytes()}
                .toList()

        // Executes the given [block] function on this resource and then closes it down correctly whether an exception is thrown or not.
        ZipInputStream(ByteArrayInputStream(bytes.get(0)))
            .use { zis : ZipInputStream->
                var entry = zis.nextEntry
                while(entry != null){
                    if(!entry.isDirectory){ // file, not directory
                        println("szw ${entry.name}")
                    }
                    entry = zis.nextEntry
                }
            }
    }

    fun testZip2(){
        var zipFile = ZipFile("test3.zip")
        var entries = zipFile.entries()
        while(entries.hasMoreElements()){
            var entry = entries.nextElement()
            println("  : ${entry.name}")
        }

    }
}