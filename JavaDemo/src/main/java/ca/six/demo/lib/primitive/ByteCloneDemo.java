package ca.six.demo.lib.primitive;

/**
 * Created by songz2 on 9/21/2016.
 */
public class ByteCloneDemo {
    public static void main(String[] args) {
        byte[] raw = new byte[] { 1, 23, 14 };

        byte[] to = raw.clone();
        print(raw);  // szw : 1 23 14
        print(to);   // szw : 1 23 14
        System.out.println("=========");

        raw[0] = 9; raw [1] = 0;
        print(raw);  // szw : 9 0 14
        print(to);   // szw : 1 23 14
        System.out.println("=========");

        byte[] to2 = raw.clone();
        print(raw);  // szw : 9 0 14
        print(to);   // szw : 1 23 14
        print(to2);  // szw : 9 0 14
        System.out.println("=========");

        to2[0] = 3; to2[1] = 8;
        print(raw);  // szw : 9 0 14
        print(to);   // szw : 1 23 14
        print(to2);  // szw : 3 8 14
        System.out.println("=========");

    }

    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(b);
            sb.append(" ");
        }
        System.out.println("szw : "+sb.toString());
    }
}