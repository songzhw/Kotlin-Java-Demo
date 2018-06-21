package java7.autoclose;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AutocloseDemo {

    String readFirstLine_priorToJava7(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }

    String readFirstLine_java7(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public void writeToFileZipFileContents(String src, String out) throws java.io.IOException {
        Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        Path outputFilePath = java.nio.file.Paths.get(out);

        try (
                ZipFile zf = new ZipFile(src);
                BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset)
        ) {
            for (Enumeration entries = zf.entries(); entries.hasMoreElements(); ) {
                String newLine = System.getProperty("line.separator");
                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }

    public void custom1() {
//        try(String str = "abc") {}

        try (MyResource res1 = new MyResource()) {
            System.out.println(res1);
        }
    }

    public void custom() {
        System.out.println("001");
        try (MyResource res = new MyResource()) {
            System.out.println(res);
        } catch (Exception e) {
            System.out.println("002");
            e.printStackTrace();
        } finally {
            System.out.println("003");
        }
        System.out.println("004");
    }
    /*
    001
    java7.autoclose.MyResource@66d3c617
    MyResource close()
    003
    004
     */

    public static void main(String[] args) {
        AutocloseDemo obj = new AutocloseDemo();
        obj.custom();
    }

}

class MyResource implements AutoCloseable {
    String member = "xxx";

    @Override
    public void close() {
        member = null;
        System.out.println("MyResource close()");
    }

    // 另一可能 public void close() throws Exception {
}
