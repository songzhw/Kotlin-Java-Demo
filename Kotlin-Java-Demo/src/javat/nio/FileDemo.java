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
        RandomAccessFile file = new RandomAccessFile("data1.txt", "rw");
        FileChannel in = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = in.read(buf);
        while(bytesRead != -1){
            System.out.println("Read "+bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            bytesRead = in.read(buf);
        }
        file.close();
    }
}
