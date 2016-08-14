package javat.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songzhw on 2016-08-14.
 */
public class NonCovariantGenerics {
    public static void main(String[] args) {
        List<Fruit> list1 = new ArrayList<>();

        // Compile Error : incompatible types
//        List<Fruit> list2 = new ArrayList<Apple>();
/*
        List<? extends Fruit> list3 = new ArrayList<Apple>();
        list3.add(new Apple()); // complile error
        list3.add(new Fruit()); // complile error
        Fruit f = list3.get(0);

        List<? extends Fruit> list4 = new ArrayList<>();
        list4.add(new Apple()); // complile error
        list4.add(new Fruit()); // complile error
        Fruit f2 = list4.get(0);

        List<? extends Fruit> list5 = Arrays.asList(new Apple());
        Apple apple = (Apple) list5.get(0); // need to cast
        list5.contains(new Apple()); // Argument is 'Object'
        list5.indexOf(new Orange()); // okay, too

        List<? super Apple> list6 = new ArrayList<>();
        list6.add(new Apple());
        list6.add(new RedApple());
        Apple a =list6.get(0);
        list6.add(new Fruit());// error !

        List<Apple> list7 = new ArrayList<>();
        list7.add(new Apple());
        list7.add(new RedApple());
        list7.add(new Fruit());// error !

*/
    }
}
