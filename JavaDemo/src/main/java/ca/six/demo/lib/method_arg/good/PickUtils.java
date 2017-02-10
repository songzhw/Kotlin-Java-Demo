package ca.six.demo.lib.method_arg.good;

import ca.six.demo.lib.method_arg.Apple;
import ca.six.demo.lib.method_arg.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class PickUtils {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}