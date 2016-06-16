package javat.pass;

/**
 * Created by songzhw on 2016-06-16.
 */
public class A {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("szw A main(1) a0 = "+a);
        B b = new B(a);
        b.clear();
        System.out.println("szw A main(2) a0 = "+a);
    }

}
