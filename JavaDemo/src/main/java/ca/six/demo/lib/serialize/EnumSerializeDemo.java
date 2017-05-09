package ca.six.demo.lib.serialize;

import java.io.*;

public class EnumSerializeDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("p.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(Num.ONE);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Num s1  = (Num) ois.readObject();
        s1.printValues();
        ois.close();
    }
}

/*
ONEONE.ordinal0
TWOTWO.ordinal1
THREETHREE.ordinal2
*/