package ca.six.demo.lib.innerclass.normal;

import ca.six.demo.lib.innerclass.multiparents.Son;

public class Wife {
    public void foo(){
        Son son = new Son();
        Son.Son2 son2 = son.new Son2();
        son2.inherit();//=> Inner class: 10
    }
}
