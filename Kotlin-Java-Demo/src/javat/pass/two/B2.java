package javat.pass.two;

/**
 * Created by songzhw on 2016-06-16.
 */
public class B2 {
    private A2 a;

    public B2(A2 a){
        this.a = a;
        this.a.val = 20;
        System.out.println(
                "02 B2 CF() a.val = "+a.val
                +" ; B.a.val = "+this.a.val);
    }

}
