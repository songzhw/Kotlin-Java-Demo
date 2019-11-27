package threads.singleton;

public class LazySIngleton {
    private volatile static LazySIngleton singleton;
    private LazySIngleton(){}
    public static LazySIngleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySIngleton.class) {
                if (singleton == null) {
                    singleton = new LazySIngleton();
                }
            }
        }
        return singleton;
    }
}

