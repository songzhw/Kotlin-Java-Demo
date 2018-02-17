package ca.six.demo.lib.collections;

import ca.six.demo.j8.User;
import java.util.Arrays;
import java.util.List;

public class ShadowCopy {
    public static void main(String[] args) {
        User u1 = new User(1, "a");
        User u2 = new User(2, "b");
        User u3 = new User(3, "c");
        User u4 = new User(4, "d");
        User u5 = new User(5, "e");

        List<User> data = Arrays.asList(u1, u2, u3, u4, u5);
        List<User> l1 = data.subList(0, 2);
        List<User> l2 = data.subList(2, data.size());
        print(l1, "l1");
        print(l2, "l2");
        System.out.println("========================================");

        data.get(0).id = 11;
        print(l1, "l1"); //=> 11, 2
        print(l2, "l2"); //=> 3, 4, 5
        System.out.println("========================================");



    }

    static void print(List<User> list, String appendx){
        System.out.println("        "+appendx);
        list.forEach(System.out::println);
    }
}

/*
1. Is subList() a shadow copy, or deep copy?
: yes, it's a shadow copy.

2.
:


*/
