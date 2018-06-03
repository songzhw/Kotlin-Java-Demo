import java.util.function.Supplier;

public class Temp {

    static ThreadLocal<String> localLooper = ThreadLocal.withInitial(new Supplier<String>() {
        @Override
        public String get() {
            return "";
        }
    });

    public static String myLooper() {
        return localLooper.get();
    }

    public static void loop() {

    }

    public void getMessageQueue() {

    }

    public void quit() {

    }

}
