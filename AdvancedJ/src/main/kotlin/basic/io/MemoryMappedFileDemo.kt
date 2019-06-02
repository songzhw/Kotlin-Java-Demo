package basic.io

import java.io.RandomAccessFile
import java.nio.channels.FileChannel

fun main(args: Array<String>) {
    val size = 0x800_000L

    // 创建 8.4 MB 大小的temp.txt
    val fileChannel = RandomAccessFile("temp.txt", "rw").channel
    val mappedBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, size)

    for (i in 0 until size) {
        mappedBuffer.put(i.toByte())
    }
    println("done writing")

    val index = 10
    mappedBuffer.get(index)  //类似于RandomAccessFile()中的seek(10), 并read()出结果


    fileChannel.close()
}