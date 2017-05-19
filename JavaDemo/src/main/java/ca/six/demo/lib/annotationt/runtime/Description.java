package ca.six.demo.lib.annotationt.runtime;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented

public @interface Description {
    String value();
}