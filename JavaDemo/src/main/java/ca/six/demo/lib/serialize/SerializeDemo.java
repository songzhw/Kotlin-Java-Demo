package ca.six.demo.lib.serialize;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("szw");  // after here, index = 1
        System.out.println("user = "+user);
        User user2 = new User("222"); // after here, index = 2

        File file = new File("mine.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(user);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object newUser  = ois.readObject();
        ois.close();

        // 由这可知, 存数据是存不了static的。
        System.out.println(newUser); //=> User{id=1, name='szw' ; static index = 2}

    }
}