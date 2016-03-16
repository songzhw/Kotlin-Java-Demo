package lambda;

import java.util.concurrent.Callable;

/**
 * Created by songzhw on 3/16/16.
 */
public class Exercises02 {
    public static void main(String[] args) {
        Exercises02 obj = new Exercises02();
        obj.exer06();

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

    // 7. Write a static method "andThen" that takes as parameters two "Runnable" instances
    // and returns a "Runnable" that runs the first, then the second.
    // In the main method, pass two lambda expressions into a call to "andTehen",
    // and run the returned instance
    public void exer07(){

    }

    public static void andThen(Runnable r1, Runnable r2){

    }
}

interface RunnableEx {
    void run() throws Exception;
}
