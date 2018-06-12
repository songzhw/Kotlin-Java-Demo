package tmp;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

class Exp<T> {
    T name;
    long id;

    public void f1(T t) {
    }

    public T f2() {
        return null;
    }
}



public class ReflectionGenericsDemo {
    public static void main(String[] args) throws Exception{
        Class<?> clz = Exp.class;

        System.out.println("一．  不是泛型, Type就会是Class");
        Field filed2 = clz.getDeclaredField("id");
        Type t2 = filed2.getGenericType();  // class: Class
        System.out.println("t2.class = "+t2.getClass());
        System.out.println();

        System.out.println("二．  成员变量类型的泛型参数: TypeVariable");
        Field filed = clz.getDeclaredField("name"); //clz.getField()只能获取public成员. 所以这里用clz.getDeclaredField()
        Type t1 = filed.getGenericType();  // class: TypeVariableImpl. 可以认为是TypeVariable的类型.
        System.out.println("t1.class = "+t1.getClass());
        System.out.println();


        System.out.println("三．  成员方法返回值的泛型参数。");

        System.out.println();


        System.out.println("四．  成员方法参数类型的泛型参数");

        System.out.println();


        System.out.println("五．  构造方法参数类型的泛型参数");

        System.out.println();

    }
}