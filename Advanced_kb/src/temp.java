import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class temp {
    public void foo() throws IOException {
        final List<File> files = new ArrayList<File>();
        SimpleFileVisitor<Path> finder = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                files.add(file.toFile());
                return super.visitFile(file, attrs);
            }
        };

        Path path = Paths.get("/Users/zsong/temp/epub_reader/html_unzipped");
        java.nio.file.Files.walkFileTree(path, finder);

        for (int i = 0; i < files.size(); i++) {
            System.out.println("szw " + files.get(i).getAbsolutePath());
        }
    }

    public static void main(String[] args) throws IOException {
        new temp().foo();
    }

}
