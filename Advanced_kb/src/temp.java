import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.util.Zip4jUtil;
import org.zeroturnaround.zip.ZipUtil;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ForkJoinPool;
import java.util.zip.*;

class temp {
    public static void main(String[] args) throws IOException {
        String from = "/Users/zsong/temp/epub_reader/html_unzipped";
        String to = "/Users/zsong/temp/epub_reader/t21.zip";

//        pack8(fromFolder, toFile);  // it works, but only >= android api 26 (android 8)

        ZipUtil.pack(new File(from), new File(to)); // works
    }

    public static void pack8(String sourceDirPath, String zipFilePath) throws IOException {
        Path p = Files.createFile(Paths.get(zipFilePath));
        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p))) {
            Path pp = Paths.get(sourceDirPath);
            Files.walk(pp)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    });
        }
    }
}
