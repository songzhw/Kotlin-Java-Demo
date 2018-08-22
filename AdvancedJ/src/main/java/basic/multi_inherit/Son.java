package basic.multi_inherit;

public class Son extends Father {
    void foo(){
        strength(); //=> from father

        Son2 son2 = new Son2();
        son2.inheritMother(); //=> from mother
    }

    class Son2 extends Mother {
        void inheritMother(){
            calm();
        }
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.foo();
    }
}