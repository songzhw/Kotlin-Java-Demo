package stream;

import java.util.Arrays;
import java.util.List;

/**
 * songzhw - 2016/3/28
 * Copyright 2016 Six.
 */
public class PeopleRepo {
    public static List<Person> getPersons(){
        return Arrays.asList(
                new Person("one", 21, "Toronto"),
                new Person("two", 31, "Bay"),
                new Person("three", 16, "Bay"),
                new Person("four", 32, "Houston"),
                new Person("five", 32, "Toronto")

        );
    }
}
