package stream;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * songzhw - 2016/3/31
 * Copyright 2016 Six.
 */
public class StringJoinDemo {

    public void foo(){
        Stream<Person> stream = PeopleRepo.getPersons().stream();
        String names = stream.map( p -> p.name)
                .collect( Collectors.joining(","));
        System.out.println("szw : longName = "+names);
        // => szw : longName = one,two,three,four,five
    }

    public static void main(String[] args) {
        StringJoinDemo obj = new StringJoinDemo();
        obj.foo();
    }
}
