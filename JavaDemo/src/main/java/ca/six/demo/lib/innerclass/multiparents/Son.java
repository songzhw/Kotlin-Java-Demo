package ca.six.demo.lib.innerclass.multiparents;

public class Son extends Father {
    private int age = 10;

    public class Son2 extends Mother {
        public void inherit(){
            System.out.println("Inner class : "+age); //=> Inner class : 10
        }
    }
}

