package ca.six.demo.j8.optional;


import ca.six.demo.j8.User;

import java.util.Optional;
import java.util.Random;

public class OptionDemo {

    public void foo1(Optional<String> arg){

    }

    public Optional<String> foo2(String arg){
        Random random = new Random();
        int num = random.nextInt();
        if(num % 2 == 0){
            return null;
        } else {
            return Optional.of("");
        }
    }

    public String oldWay(User user){
        if(user != null){
            String name = user.name;
            if(name != null){
                return name.toUpperCase();
            }
        }
        return null;
    }

    public String newWay(User user){
        Optional<User> userOpt = Optional.ofNullable(user);
        // map(user.name)是错的。 因为map(arg)里的这个arg一定得是个Function对象
        return userOpt.map(User::getName)
                    .map(String::toUpperCase)
                    .orElse(null);
    }

    public static void main(String[] args) {
        OptionDemo obj = new OptionDemo();
        String test = obj.newWay(null);
        System.out.println("szw test = "+test);

    }
}
