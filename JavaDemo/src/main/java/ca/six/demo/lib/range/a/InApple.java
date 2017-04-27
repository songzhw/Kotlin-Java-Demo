package ca.six.demo.lib.range.a;

public class InApple extends Apple {

    public void foo(){
        Apple apple = new Apple();
        apple.getId();
        apple.getType();
        apple.id = 3;
        apple.type = "";
    }

    @Override
    String getType() {
        return super.getType();
    }

    @Override
    protected int getId() {
        return super.getId();
    }
}