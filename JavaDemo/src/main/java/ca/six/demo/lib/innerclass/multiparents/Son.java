package ca.six.demo.lib.innerclass.multiparents;

public class Son extends Father {
    void foo(){
        strength(); //=> from father

        Son2 son2 = new Son2();
        son2.inherit();
    }

    class Son2 extends Mother {
        void inherit(){
            calm();
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.foo();
    }
}

