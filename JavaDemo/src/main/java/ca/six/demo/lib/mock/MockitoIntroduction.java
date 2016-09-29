package ca.six.demo.lib.mock;

/**
 * Created by songzhw on 2016-09-28
 */

// 1. test the void method
// 2. mock the exception
public class MockitoIntroduction {

    public int add(int a, int b) {
        return a + b;
    }

    public void print(MyString str) {
        str.print();
    } // MyString class only has one method, called "print()"

    public double divide(double a, double b) {
        try {
            return a / b;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
