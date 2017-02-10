package ca.six.demo.lib.method_arg.better;

import ca.six.demo.lib.method_arg.Predicate;

import java.util.ArrayList;
import java.util.List;

public class PickUtils {

    public static <T> List<T> filter(List<T> original, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T item : original){
            if(p.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}