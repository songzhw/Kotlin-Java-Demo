package kotlin_sample.dex_counter

import java.io.File
import java.io.FileInputStream

/**
 * Created by songzhw on 2016/2/13.
 */

//
fun main(args: Array<String>) {
    var sample = DexCount01()
    sample.testBytes()
}

class DexCount01 {
    fun testBytes(){
        var bytes : List<ByteArray> = arrayListOf("README.md")
                .map { FileInputStream(File (it.toString() ))}
                .map { it.readBytes()}
                .toList()

        bytes.forEachIndexed { index, bytes ->
            println("$index : "+String(bytes))
        }
    }
}

