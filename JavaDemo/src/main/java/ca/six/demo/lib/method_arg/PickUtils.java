package ca.six.demo.lib.method_arg;

import java.util.ArrayList;
import java.util.List;

public class PickUtils {

    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if("green".equalsIgnoreCase(apple.color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result=new ArrayList<>();
        for (Apple apple : inventory) {
            if(apple.color.equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    // call the method like this:
    //  List<Apple> greenApples = filterApples(inventory, "green",150,true);
    //  List<Apple> redApples = filterApples(inventory, "red",120,false);
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.color.equals(color)) || (flag && apple.weight > weight)) {
                result.add(apple);
            }
        }
        return result;
    }


}
