package ca.six.demo.lib.thread.falsewake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songzhw on 2016-07-28.
 *
 * What's wrong with this code?
 * : [Answer] false awake
 */
public class FalseWakeStack {
    private List<String> list = new ArrayList<>();

    public void push(String v){
        synchronized (this) {
            list.add(v);
            notify();
        }
    }

    public String pop() throws InterruptedException {
        synchronized (this) {
            if(list.size() <= 0) {
                wait();
            }
            return list.remove(list.size()-1);
        }
    }

}
