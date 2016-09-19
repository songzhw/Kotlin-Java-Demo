package ca.six.demo.lib.mock;

import java.util.List;

public class MyCounter {

    public MyCounter() {
    }

    public int count(List items) {
        int results = 0;
        for (Object curItem : items) {
            results++;
        }
        return results;
    }
}