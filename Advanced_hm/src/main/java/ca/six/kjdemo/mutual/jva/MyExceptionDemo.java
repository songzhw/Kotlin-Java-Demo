package ca.six.kjdemo.mutual.jva;

import ca.six.kjdemo.mutual.kt.MyExceptionKt;

class MyExceptionDemo {
    public static void main(String[] args) {
        try {
            MyExceptionKt.iThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
