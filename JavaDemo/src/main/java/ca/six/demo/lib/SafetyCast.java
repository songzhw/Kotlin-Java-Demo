package ca.six.demo.lib;


import java.util.LinkedHashSet;
import java.util.Set;

public class SafetyCast {
    public static void main(String[] args) {
        Main main = new Main();
        User user = main.change(main.getObject());
        if(user == null){
            System.out.println("empty"); //=> get this one. No NPE crash
        } else {
            System.out.println("user = "+user);
        }
    }

    public Object getObject() {
        return null;
    }

    public User change(Object obj) {
        return (User)obj;
    }

}




