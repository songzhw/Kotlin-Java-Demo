package ca.six.demo.lib.innerclass.inherit;

public class Test2 {
    private int id = 10;
    static class Inner2{
        protected int num = 11;
    }
}

class Inner2Child extends Test2.Inner2{
    public Inner2Child(){
        num = 23;
    }
}
