package ca.six.demo.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {
    // Checked Exception: FileNotFoundException <- IOException <- Exception
    public void foo() throws FileNotFoundException {
        File file = new File("b.txt");
        FileInputStream fis = new FileInputStream(file);
    }

    public void bar() throws MyRunError {
        throw new MyRunError();
    }

    public static void main(String[] args) {
        ExceptionDemo obj = new ExceptionDemo();

        try {
            obj.foo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        obj.bar();
    }
}

class MyRunError extends RuntimeException {
}