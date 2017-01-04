package ca.six.demo.lib.okio;

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
    }

    public static void write2File(){

    }

    public static void readFile(){
        try {
            File file = new File("a"); // 位置得在工程根目录下！
            BufferedSource bufferedSource = Okio.buffer(Okio.source(file));
            String str = bufferedSource.readByteString()
                            .string(Charset.forName("utf-8"));
            System.out.println("szw : "+str);
        }catch (Exception e){
            System.err.println("szw : "+e);
        }
    }
}
