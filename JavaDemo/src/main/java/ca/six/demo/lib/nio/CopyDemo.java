package ca.six.demo.lib.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by songzhw on 2017-03-01.
 */
public class CopyDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file1 = new RandomAccessFile("data1.txt", "rw");
        FileChannel from = file1.getChannel();
        RandomAccessFile file2 = new RandomAccessFile("data2.txt", "rw");
        FileChannel to = file2.getChannel();

        long position = 0;
        long count = from.size();
        to.transferFrom(from, position, count); //to不存在，就会新建data2.txt文件的!

    }
}
