package javat.pass.two;


/**
 * Created by songzhw on 2016-06-16.
 */
public class A2 {
    public int val = 10;

    public static void main(String[] args) {
        A2 a = new A2();
        System.out.println("szw A main(1) a.val = "+a.val);
        B2 b = new B2(a);
        System.out.println("szw A main(2) a.val = "+a.val);
    }

}
