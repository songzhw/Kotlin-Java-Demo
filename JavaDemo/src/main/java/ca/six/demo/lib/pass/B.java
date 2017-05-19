package ca.six.demo.lib.pass;

/**
 * Created by songzhw on 2016-06-16.
 */
public class B {
    private A a;

    public B(A a){
        System.out.println("szw B CF() : a1 "+a);
        this.a = a;
        System.out.println("szw B CF() : a2 "+this.a);
    }

    public void clear(){
        this.a = null;
        System.out.println("szw B clear() : a2 "+this.a);
    }
}
