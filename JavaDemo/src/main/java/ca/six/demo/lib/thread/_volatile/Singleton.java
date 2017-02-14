package ca.six.demo.lib.thread._volatile;

/**
 * Created by songzhw on 2017-02-13.
 */
public class Singleton {
    // Singleton Instance is declared as volatile variable to ensure every thread see updated value for `instance`
    private volatile static Singleton instance;

    private Singleton(){}

    private Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}