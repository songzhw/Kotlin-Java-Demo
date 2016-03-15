package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by songzhw on 2016/3/15.
 */
public class Exercises01 {

    public static void main(String[] args) {
        Exercises01 obj = new Exercises01();
        obj.exer01();
        obj.printDivider();

        obj.exer02();
        obj.printDivider();


        obj.printDivider();


        obj.printDivider();
    }

    private void printDivider(){
        System.out.println("====================================");
    }

    // 1. Is the comparator code in the “Arrays.sort" method called in the same  thread
    // as the call to "sort" or a different thread.
    public void exer01() {
        String[] strings = new String[]{"test", "sample", "exercise"};
        System.out.println("szw001 Thread = " + Thread.currentThread().getName()); //=> main
        Arrays.sort(strings, (x, y) -> {
            System.out.println("szw002 Thread = " + Thread.currentThread().getName()); //=> main
            return x.compareToIgnoreCase(y);
        });
        // Answer : Yes, the same thread
    }

    // 2. Using the "listFiles(FileFilter)" and "isDirector" methods of java.io.File class,
    // write a method that returns all subdirectories of a given directory.
    // Use a lambda expression instead of a FileFilter object.
    // Repeat with a method expression.
    public void exer02() {
        File root = new File("E:/temp");
        File[] subs = root.listFiles((File parent, String name)->{
            File me = new File(parent, name);
            return me.isDirectory();
        });

        for (File sub : subs) {
            System.out.println(sub.getName());
        }
    }
}
