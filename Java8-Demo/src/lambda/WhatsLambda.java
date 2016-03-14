package lambda;

/**
 * Created by songzhw on 2016/3/14.
 */

@FunctionalInterface
interface Print<T> {
    public void print(T x);
}

public class WhatsLambda {
    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }

//    private static void lambda$main$0(String str){}

    public static void main(String[] args) {
        PrintString("test", (x) -> System.out.println(x));
    }
}
