package javat.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by songzhw on 2017-02-28.
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 数据从 Channel 读到 Buffer 中
        RandomAccessFile file = new RandomAccessFile("data1.txt", "rw");
        FileChannel in = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);

        // 1. 写入数据到 Buffe
        int bytesReadCount = in.read(buf);
        while(bytesReadCount != -1){
            System.out.println("Read "+bytesReadCount);
            // 2. 调用flip()方法 (flip(): 将 Buffer从"写"切换到"读"模式)
            buf.flip();
            // 3. 从Buffer中读取数据
            while(buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            // 4. 调用clear()方法或者 compact()方法
            buf.clear();
            bytesReadCount = in.read(buf);
        }
        file.close();
    }
}
