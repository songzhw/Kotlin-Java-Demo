package ca.six.kex;

import java.util.HashMap;

public class Sp {
    private HashMap<String, String> map = new HashMap<>();

    public Sp save(String key, String value){
        map.put(key, value);
        return this;
    }

    public String get(String key){
        return map.get(key);
    }

}
