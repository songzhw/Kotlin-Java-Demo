package basic.io

import java.io.RandomAccessFile


fun readFile() {
    val stream = RandomAccessFile("build.gradle", "rw")
    println("first position = ${stream.filePointer}")

    stream.seek(6)
    println("then position = ${stream.filePointer}")

    val buff = ByteArray(1024)
    var readedCount = stream.read(buff)

    while (readedCount > 0) {
        println(String(buff, 0, readedCount))
        readedCount = stream.read(buff)
    }

}


fun main(args: Array<String>) {
    readFile()
}