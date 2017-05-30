package ca.six.demo.lib.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by songzhw on 2017-02-28.
 */
public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        // 数据从 Channel 读到 Buffer 中
        RandomAccessFile file = new RandomAccessFile("data1.txt", "rw");
        FileChannel in = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        // 1. 从channel, 写入数据到 Buffer
        int bytesReadCount = in.read(buf);
        while (bytesReadCount != -1) {
            System.out.println("Read " + bytesReadCount);
            // 2. 调用flip()方法 (flip(): 将 Buffer从"写"切换到"读"模式)
            buf.flip();
            // 3. 从Buffer中读取数据
            while (buf.hasRemaining()) {
                System.out.println((char) buf.get());//read 1 byte at a time
            }
            // 4. 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入
            // 调用clear()方法或者 compact()方法 || clear()方法会清空整个缓冲区。
            // compact()方法只会清除已经读过的数据，任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
            buf.clear();
            bytesReadCount = in.read(buf);
        }
        in.close();
        file.close();
    }
}

// 注意： StringBuffer可不是NIO的类哦