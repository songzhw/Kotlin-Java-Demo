package rxjavat.file;

import java.io.*;

/**
 * Created by songzhw on 2016-06-16.
 */
public class FileUtils {

    public static String getFileContent(File file) {
        try {
            InputStream is = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            long len = is.available();
            int length = (int) len;
            byte bytearray[] = new byte[length];
            bis.read(bytearray, 0, length);
            return new String(bytearray);
        } catch (Exception e) {
            System.out.println("szw getFileContent() : error = " + e.toString());
            e.printStackTrace();
            return null;
        }

    }

    public static void saveFileContent(String content, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            System.out.println("szw saveFileContent() : error = " + e.toString());
            e.printStackTrace();
        }

    }

}
