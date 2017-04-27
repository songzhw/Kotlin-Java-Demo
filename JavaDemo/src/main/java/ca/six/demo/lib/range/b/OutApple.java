package ca.six.demo.lib.range.b;

import ca.six.demo.lib.range.a.Apple;

//public class OutApple extends DefaultApple{  //=> compile error
public class OutApple extends Apple {

    public void foo(){
        Apple apple = new Apple();
//        apple.type = 3;  //=> compile error
//        apple.getId();   //=> compile error
//        apple.getType(); //=> compile error

        id = 3;
//        type = "";   //=> compile error
    }

    @Override
    protected int getId() {
        return super.getId();
    }

//  @Override  getType()   //=> compile error
}
