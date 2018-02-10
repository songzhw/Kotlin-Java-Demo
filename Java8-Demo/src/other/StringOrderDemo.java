package other;

import functions.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringOrderDemo {
    public static void main(String[] args) {
        User u1 = new User(1, "idea");
        User u2 = new User(2, "java");
        User u3 = new User(3, "Java");
        User u4 = new User(4, "king");

        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);

        list.sort(Comparator.comparing(usr -> usr.name));

        for (User u : list) {
            System.out.println(u);
        }
    }
}
// Java, idea, java, king
