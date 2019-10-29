import org.zeroturnaround.zip.ZipUtil;

import java.io.*;
import java.util.zip.*;

class temp {
    public static void main(String[] args) {
        String fromFolder = "/Users/zsong/temp/epub_reader/html_unzipped";
        String toFile = "/Users/zsong/temp/epub_reader/t11.zip";

        ZipUtil.pack(new File(fromFolder), new File(toFile));
    }
}
