package ca.six.demo.lib.serialize;

import java.io.*;

public class SerializeDemo2 {
    public static void main(String[] args) throws Exception {
        StudentUser user = new StudentUser("test");  // after here, index = 1
        User user2 = new User("222-1"); // after here, index = 2

        File file = new File("mine.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(user);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object newUser  = ois.readObject();
        ois.close();

        // 由这可知, 存数据是存不了static的。
        System.out.println(newUser); //=> User{id=1, name='test' ; static index = 2}

    }
}