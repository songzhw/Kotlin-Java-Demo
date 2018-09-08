package basic.io

import java.io.RandomAccessFile


fun readFile() {
    val stream = RandomAccessFile("build.gradle", "rw")
    println("first position = ${stream.filePointer}")

    //在最末追回一个注释
    val comment = "\n// added by RandomAccessFile demo"
    stream.seek(stream.length())
    stream.write(comment.toByteArray())  //java中是用"write(comment.getBytes())"


    // 要开始读取文件, 就得再移支指针到最开始来
    stream.seek(0)
    val buff = ByteArray(1024)
    var readedCount = stream.read(buff)

    while (readedCount > 0) {
        println(String(buff, 0, readedCount))
        readedCount = stream.read(buff)
    }

    stream.close()
}



fun main(args: Array<String>) {
    readFile()
}