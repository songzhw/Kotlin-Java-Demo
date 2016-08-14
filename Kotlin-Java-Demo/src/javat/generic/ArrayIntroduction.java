package javat.generic;

/**
 * Created by songzhw on 2016-08-14.
 */
public class ArrayIntroduction {
    public static void main(String[] args) {
        Fruit[] ary = new Apple[10];
        ary[0] = new Apple();
        // compiler allows, however, crash at runtime
        ary[1] = new Fruit(); //error
    }
}
