package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by songzhw on 2016/3/14.
 */
public class ObjectOrNot {

    public static void main(String[] args) {
        // 1. Error : Target type of a lambda coversion must be an interface
        /*
        Object obj1 = ()->{
            System.out.println("first");
        };
        */

        // 2. lambda & functional interface
        Runnable r2 = ()-> System.out.println("lambda No.2");
        Object obj2 = r2;

        // 3. The below two lines are both okay for Java compiler
        Runnable r3 = ()-> System.out.println("lambda No.2");
        MyRunnable r4 = ()-> System.out.println("lambda No.2");



    }

}
