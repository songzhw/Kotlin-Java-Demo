package ca.six.kjdemo;


class A {

}

class B {
    public static void main(String[] args) {
        A a = new A();
        foo(a);
        boolean isNull = a == null;
        System.out.println(isNull + "; " + a); //=> false;   ca.six.kjdemo.A@2c7b84de
    }

    public static void foo(A arg) {
        System.out.println("B: " + arg); //=> B: ca.six.kjdemo.A@2c7b84de
        arg = null;
    }
}
