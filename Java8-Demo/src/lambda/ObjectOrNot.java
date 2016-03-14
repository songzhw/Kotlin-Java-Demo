package lambda;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by songzhw on 2016/3/14.
 */
public class ObjectOrNot {

    public void foo() throws Exception {
        // 1. Error : Target type of a lambda coversion must be an interface
        /*
        Object obj1 = ()->{
            System.out.println("first");
        };
        */

        // 2. lambda & functional interface
        Runnable r2 = () -> System.out.println("lambda No.2");
        Object obj2 = r2;

        // 3. The below two lines are both okay for Java compiler
        Runnable r3 = () -> System.out.println("lambda No.2");
        MyRunnable r4 = () -> System.out.println("lambda No.2");

        // 4. pre-defined functional interface
        Function<Integer, String> s;
        BiFunction<String, String, Integer> bf = (first, second) -> {
            return Integer.compare(first.length(), second.length());
        };
        Consumer<Integer> c;
        Predicate<Integer> p;

        // 5. nested lambda
        Callable<Runnable> callable = () -> () -> {
            System.out.println("Runnable in Callable");
        };

        Callable<Integer> c2 = true ? (()->42) : (()->24);
        System.out.println("5. result = "+c2.call());

        // 6. Java的λ表达式只能用作赋值、传参、返回值等。
        // Error : 不可像函数一样接收参数。 这跟很多语言不一样。
//        int five = ( (x, y) -> x + y ) (2, 3);

        // 7. Method Reference
        List<String> foods = Arrays.asList("Huoguo","Sushi");
//        foods.forEach(PersonOne::eat);  // Error: Non-static method
        PersonOne one = new PersonOne();
        foods.forEach(one::eat);

    }

    public static void main(String[] args) throws Exception {
        ObjectOrNot oon = new ObjectOrNot();
        oon.foo();
    }
}

class PersonOne{
    public void eat(String food){};
}
