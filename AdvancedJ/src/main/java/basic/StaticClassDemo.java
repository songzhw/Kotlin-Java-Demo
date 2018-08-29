package basic;

public class StaticClassDemo {
    private int id = 100;
    StaticClassDemo(){}
    public void outFoo() { }

    private static int age = 10;
    private static void boo(){}

    public static class Inner {
        public void foo() {
            StaticClassDemo obj = new StaticClassDemo();
            obj.outFoo();
            System.out.println("id = " + obj.id);

            age = 20;
            boo();
        }
    }

    public class Inner2 {
        public void foo(){
            outFoo();
            System.out.println("id = "+id);

            StaticClassDemo.boo();
            StaticClassDemo.age = 20;
        }
    }
}

class Demo{
    public static void main(String[] args) {
        StaticClassDemo.Inner inner = new StaticClassDemo.Inner();

        StaticClassDemo obj = new StaticClassDemo();
        StaticClassDemo.Inner2 inner2 = obj.new Inner2();
    }
}
