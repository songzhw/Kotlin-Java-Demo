package ca.six.demo.lib.okio;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created by songzhw on 2017-01-02.
 */
public class FileIODemo {

    public static void main(String[] args) {
        readFile();
        System.out.println("============");
        write2File();
        System.out.println("============");
        readFileByLine();
        System.out.println("============");
    }

    public static void write2File() {
        // sink是输出相关的
        try {
            File file = new File("b"); // 位置得在工程根目录下！
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedSink sink = Okio.buffer(Okio.sink(file));
            Charset utf8 = Charset.forName("utf-8");
            sink.writeString("Ideal Community 2016.3.2", utf8);//不会换行的
            sink.writeString("Android Studio 2.2\n", utf8);//换行了！
            sink.writeString("test3", utf8);
            sink.close();
        } catch (Exception e) {
            System.err.println("szw2 : " + e);
        }
    }

    public static void readFile() {
        // source是输入相关的
        try {
            File file = new File("a"); // 位置得在工程根目录下！
            BufferedSource bufferedSource = Okio.buffer(Okio.source(file));
            String str = bufferedSource.readByteString()
                    .string(Charset.forName("utf-8"));
            System.out.println("szw : " + str);
        } catch (Exception e) {
            System.err.println("szw : " + e);
        }
    }

    private static void readFileByLine() {
        try {
            File file = new File("b"); // 位置得在工程根目录下！
            BufferedSource source = Okio.buffer(Okio.source(file));
            String line = null;
            // 没有source.getLineCount()这样的方法，只好用while循环了. 到底了就会返回null的
            while( (line = source.readUtf8Line()) != null){
                System.out.println("szw 3 : line = "+line);
            }
        } catch (Exception e) {
            System.err.println("szw : " + e);
        }
    }
}
