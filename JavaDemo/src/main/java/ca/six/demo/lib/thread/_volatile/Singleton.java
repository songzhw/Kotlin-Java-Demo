package ca.six.demo.lib.thread._volatile;

/**
 * Created by songzhw on 2017-02-13.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    private Singleton getInstance(){
        if(instance == null){
            synchronized (this) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
