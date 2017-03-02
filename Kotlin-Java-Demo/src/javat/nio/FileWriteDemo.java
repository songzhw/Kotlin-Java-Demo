package javat.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by songzhw on 2017-03-01.
 */
public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("data3.txt", "rw");
        FileChannel channel = file.getChannel();

        String data = "New string : " + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(data.getBytes());

        buf.flip();
        while(buf.hasRemaining()){
            channel.write(buf);
        }
        channel.close();
        file.close();
    }
}
