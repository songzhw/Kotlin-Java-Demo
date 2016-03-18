package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by songzhw on 3/16/16.
 */
public class Exercises02 {
    public static void main(String[] args) {
        Exercises02 obj = new Exercises02();
        obj.exer06();

        obj.exer08();

        obj.exer09();

    }

    private void printDivider() {
        System.out.println("====================================");
    }

    /*
    6. Didn't you always hate it that you had to deal with checked exceptions in  Runnable?
    Write a method "uncheck" that catches all checked exceptions
    and turns them into unchecked exception. For eaxmaple:
        new Thread( uncheck(
            ()->{sout("zz"; Thread.sleep(1000);} )).start();
            // Look, no catch InterruptedException.
     */
    private void exer06() {
        Runnable r = uncheck(() -> {
            Thread.sleep(1000);
            System.out.println("====== exer06 over ======");
        });
        new Thread(r).start();
    }

    private Runnable uncheck(RunnableEx ex) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    ex.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }


    // =======================================

    // 8. Write a static method "andThen" that takes as parameters two "Runnable" instances
    // and returns a "Runnable" that runs the first, then the second.
    // In the main method, pass two lambda expressions into a call to "andTehen",
    // and run the returned instance
    public void exer08(){
        String[] names = {"peter","paul","Mary"};
        List<Runnable> runners = new ArrayList<>();
        for(String name : names){
            runners.add( ()-> System.out.println(name));
        }

         /*
         * Error!!!
         *     (Because "i" is not effectively final, so lambda report illeagl!)
        for(int i = 0 ; i < names.length ; i++){
            runners.add( ()-> System.out.println(names[i]));
        }
         * */
    }


    // =======================================

    // 9. Form a subclass "Collection2" from "Collection" and add a default method "void forEachIf(Consumer action, Predicater filter)
    // t hat applies action to each element for which filter returns true. How could you use it?
    public void exer09(){
        Collection2<String> tmp = null; // just for example
        tmp.forEachIf(System.out::println,
                (String str) -> str.length() > 2);
    }

}

interface RunnableEx {
    void run() throws Exception;
}



interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter){
        forEach( (T t) -> {
            if(filter.test(t)){
                action.accept(t);
            }
        });
    }
}
