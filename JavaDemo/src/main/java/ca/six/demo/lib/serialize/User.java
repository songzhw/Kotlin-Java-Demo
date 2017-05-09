package ca.six.demo.lib.serialize;

import java.io.Serializable;

public class User {
    private int id;
    public String name;
    public static int index = 0;

    public User(String name) {
        index++;
        id = index;
        this.name = name;
    } 
}