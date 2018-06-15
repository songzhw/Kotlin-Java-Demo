package tmp;

import aop.proxy.retrofit.Demo.User;

import java.lang.reflect.*;
import java.util.List;

class Exp<T> {
    T name;
    long id;

    public void fIn(T t) {
    }

    public T fOut() {
        return null;
    }

    public List<T> fOut2() {
        return null;
    }

    public void fIn2(List<T> t) {
    }

    public void fWild(List<? extends User> data) {

    }
}


public class ReflectionGenericsDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Exp.class;

        System.out.println("一．  不是泛型, Type就会是Class");
        Field filed2 = clz.getDeclaredField("id");
        Type t2 = filed2.getGenericType();  // class: Class
        System.out.println("class = " + t2.getClass());
        System.out.println();

        System.out.println("二．  成员变量类型的泛型参数: TypeVariable");
        Field filed = clz.getDeclaredField("name"); //clz.getField()只能获取public成员. 所以这里用clz.getDeclaredField()
        Type t1 = filed.getGenericType();  // class: TypeVariableImpl. 可以认为是TypeVariable的类型.
        System.out.println("class = " + t1.getClass());
        System.out.println();


        System.out.println("三．  成员方法返回值的泛型参数。");
        Method m1 = clz.getDeclaredMethod("fOut");
        Type t3 = m1.getGenericReturnType();
        System.out.println("class = " + t3.getClass());  //class:  TypeVariableImpl
        System.out.println();


        System.out.println("四．  成员方法参数类型的泛型参数");
        Method m2 = clz.getDeclaredMethod("fIn", Object.class); //第二参就是函数参数的class. 这里因为是泛型, 所以只能用Object.class. 不能用String.class这样具体的
        Type[] t4 = m2.getGenericParameterTypes(); // t4.length = 1,
        System.out.println("class = " + t4[0].getClass()); // t4[0].class : TypeVariableImpl
        System.out.println();


        System.out.println("五．  成员方法返回值的泛型参数。");
        Method m3 = clz.getDeclaredMethod("fOut2");
        Type t5 = m3.getGenericReturnType();
        System.out.println("class = " + t5.getClass());  //class:  ParameterizedTypeImpl
        System.out.println();


        System.out.println("六．  成员方法返回值的泛型参数。");
        Method m4 = clz.getDeclaredMethod("fIn2", List.class);
        Type[] t6 = m4.getGenericParameterTypes(); // length = 1
        System.out.println("class = " + t6[0].getClass()); // class : ParameterizedTypeImpl
        if (t6[0] instanceof ParameterizedType) {
            Type[] actualTypes6 = ((ParameterizedType) t6[0]).getActualTypeArguments(); // length = 1
            Type actualType6 = actualTypes6[0];  // class: TypeVariableImpl
            System.out.println("\t actualType.class = " + actualType6.getClass());
        }
        System.out.println();

        System.out.println("七．  成员方法返回值的泛型参数。");
        Method m5 = clz.getDeclaredMethod("fWild", List.class); //第二参就是函数参数的class. 这里因为是泛型, 所以只能用Object.class. 不能用String.class这样具体的
        Type[] t7 = m5.getGenericParameterTypes(); // length = 1
        System.out.println("class = " + t7[0].getClass()); // class : ParameterizedTypeImpl
        if (t7[0] instanceof ParameterizedType) {
            Type[] actualTypes7 = ((ParameterizedType) t7[0]).getActualTypeArguments(); // length = 1
            Type actualType7 = actualTypes7[0];  // class: WildcardTypeImpl
            if(actualType7 instanceof WildcardType){
                Type[] wilds = ((WildcardType)actualType7).getUpperBounds(); // length : 1
                System.out.println("\t\t wildcard.class = "+wilds[0].getClass()); // class:  Class. (说明是个不带泛型的类)
            }
        }
        System.out.println();
    }
}