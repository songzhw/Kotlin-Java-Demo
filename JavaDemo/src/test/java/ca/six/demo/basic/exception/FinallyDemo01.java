package ca.six.demo.basic.exception;

/**
 * Created by songzhw on 2016-10-31.
 */
public class FinallyDemo01 {
    public static void main(String[] args) {

        // 01.
        try {
            int i = 5 / 0;
            System.out.println("Try block");
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }  //=> catch block, finally block
        System.out.println("====================");

/*
        // 02.
        try {
            System.out.println("Try block");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        } //=> try block
        System.out.println("====================");
*/

        // 03.
        FinallyDemo01 demo = new FinallyDemo01();
        demo.foo();
        System.out.println("====================");

        // 04.
        System.out.println("id = "+demo.getId()); // try, finally, id = 1

        // 05.
        System.out.println("confusing = "+demo.confusingMethod()); // finally, confusing = 3
    }

    public void foo(){
        try {
            System.out.println("try");
            return;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        } //=> try, finally
        System.out.println("====================");
    }

    public int getId(){
        try {
            System.out.println("try");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 0;
        } finally {
            System.out.println("finally");
        }

    }

    public static int confusingMethod() {
        try {
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("Finally block");
            return 3;
        }
    }


}
