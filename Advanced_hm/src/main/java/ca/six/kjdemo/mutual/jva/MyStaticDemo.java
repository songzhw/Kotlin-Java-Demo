package ca.six.kjdemo.mutual.jva;

import ca.six.kjdemo.mutual.kt.MyStatic;
import ca.six.kjdemo.mutual.kt.Static2;

class MyStaticDemo {
    public static void main(String[] args) {
        MyStatic.Companion.foo();
        MyStatic.Companion.getId();

        Static2.foo();
        Static2.getId();
    }
}
