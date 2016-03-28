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
                new Person("one", 21),
                new Person("two", 31),
                new Person("three", 16),
                new Person("four", 32),
                new Person("five", 20)

        );
    }
}
