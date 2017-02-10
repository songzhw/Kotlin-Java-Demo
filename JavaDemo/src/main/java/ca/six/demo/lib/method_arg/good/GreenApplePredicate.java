package ca.six.demo.lib.method_arg.good;

import ca.six.demo.lib.method_arg.Apple;
import ca.six.demo.lib.method_arg.ApplePredicate;

public class GreenApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equalsIgnoreCase(apple.color);
    }
}