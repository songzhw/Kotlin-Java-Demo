package ca.six.demo.lib.range.a;

public class RangeDemo3 {

    public void foo(){
        Apple apple = new Apple();
        apple.getId();
        apple.getType();
        apple.id = 3;
        apple.type = "";
    }

    // 不是Apple的子类， 自然无法重写getId(), getType()方法了
}