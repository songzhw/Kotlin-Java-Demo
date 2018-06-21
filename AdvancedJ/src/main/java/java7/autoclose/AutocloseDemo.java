package java7.autoclose;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutocloseDemo {

    String readFirstLine_priorToJava7(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }

    String readFirstLine_java7(String path) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
}
