package ca.six.demo.lib.range.b;

import ca.six.demo.lib.range.a.Apple;

public class RangeDemo4 {

    public void foo(){
        Apple apple = new Apple();

        // compile error
//        apple.getId();
//        apple.getType();
//        apple.id = 3;
//        apple.type = "";

        // compile error
//        id = 3;
//        type = "";
    }
}