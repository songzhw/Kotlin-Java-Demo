package ca.six.demo.lib.collections;

import java.util.Arrays;
import java.util.List;

public class ListRemoveDemo {
    public static void main(String[] args) {
        ListRemoveDemo main = new ListRemoveDemo();
        main.foo();
    }

    public void foo(){
        String[] arys = {"a","b"};
        List<String> list = Arrays.asList(arys);
        System.out.println("01 list = "+list);

        list.remove(0); // UnsupportedOperationException. at java.util.AbstractList.remove(AbstractList.java:161)
    }

}
