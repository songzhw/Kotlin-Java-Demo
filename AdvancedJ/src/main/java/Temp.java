import java.util.function.Supplier;

public class Temp {

    static ThreadLocal<User> localLooper = ThreadLocal.withInitial(User::new);

    public static User myLooper() {
        return localLooper.get();
    }

    public static void loop() {

    }

    public void getMessageQueue() {

    }

    public void quit() {

    }

}

class User{}