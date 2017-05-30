package ca.six.demo.lib;


import java.util.LinkedHashSet;
import java.util.Set;

public class QuickDemo {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>(); // 按插入排序，不重复
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);

        for (int i : set) {
            System.out.println(" v = " + i);
        }
    }
}




