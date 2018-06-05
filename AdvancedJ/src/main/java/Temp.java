import java.util.function.Supplier;

public class Temp {

    private String looper;
    private String callback;

    public Temp(String looper) {
        this(looper, null);
    }

    public Temp() {
        this("", null);
    }

    public Temp(String looper, String callback) {
        this.looper = looper;
        this.callback = callback;
    }

    public void sendMessage(){

    }
}

class User{}