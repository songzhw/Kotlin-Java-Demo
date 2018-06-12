package tmp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

class Exp<T> {
    T name;
    long id;

    public void fIn(T t) {
    }

    public T fOut() {
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
        Method m1 = clz.getDeclaredMethod("fOut");
        Type t3 = m1.getGenericReturnType();
        System.out.println("t3.class = "+t3.getClass());  //class:  TypeVariableImpl
        System.out.println();


        System.out.println("四．  成员方法参数类型的泛型参数");
        Method m2 = clz.getDeclaredMethod("fIn", Object.class); //第二参就是函数参数的class. 这里因为是泛型, 所以只能用Object.class. 不能用String.class这样具体的
        Type[] t4 = m2.getGenericParameterTypes(); // t4.length = 1,
        System.out.println("t4.class = "+t4[0].getClass()); // t4[0].class : TypeVariableImpl
        System.out.println();

    }
}