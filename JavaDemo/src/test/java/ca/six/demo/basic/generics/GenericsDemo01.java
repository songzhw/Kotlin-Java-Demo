package ca.six.demo.basic.generics;

import java.util.*;

/**
 * Created by songzhw on 2016-10-31.
 */
public class GenericsDemo01 {
    public static void main(String[] args) {
        // 01.
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2); //=> true. 类型擦除. 为了兼容java5之前的版本， 不管是ArrayList<Integer>()还是new ArrayList<String>()，都在编译器被编译器擦除成了ArrayList

        // 02. 本例中，我们期待的结果是得到泛型参数的类型，但是实际上我们只得到了一堆占位符
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));  //=> [E]
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));   //=> [K, V]

    }
}
