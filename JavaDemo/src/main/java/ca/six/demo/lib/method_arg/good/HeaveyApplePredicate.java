package ca.six.demo.lib.method_arg.good;

import ca.six.demo.lib.method_arg.Apple;
import ca.six.demo.lib.method_arg.ApplePredicate;

public class HeaveyApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.weight > 150;
    }
}