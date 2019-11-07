import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.util.Zip4jUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ForkJoinPool;
import java.util.zip.*;

class temp {
    public static void main(String[] args) {
        temp obj = new temp();
        try {
            obj.foo(33);
            System.out.println("end of try");
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        System.out.println("end of main()");

    }

    public void foo(int num) throws Exception {
        if (num % 2 != 0) {
            throw new Exception("we are expecting a even number");
        } else {
            System.out.println("we got: " + num);
        }
    }

}
