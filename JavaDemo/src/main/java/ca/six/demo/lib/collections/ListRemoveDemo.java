package ca.six.demo.lib.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListRemoveDemo {
    public static void main(String[] args) {
        ListRemoveDemo main = new ListRemoveDemo();
        main.foo();
    }

    public void foo(){
        String[] arys = {"a","b"};
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println("01 list = "+list);

        list.remove(0);
        System.out.println("02 list = "+list);
    }


}
