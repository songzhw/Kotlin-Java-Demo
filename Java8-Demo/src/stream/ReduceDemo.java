package stream;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * songzhw - 2016/3/24
 * Copyright 2016 Six.
 */
public class ReduceDemo {

    public void foo() {
        Stream<Integer> values = Stream.of(1, 2, 3, 4, 5);
//        Optional<Integer> sum = values.reduce(Integer::sum);
        Optional<Integer> sum = values.reduce((x, y) -> x + y);
        System.out.println("sum = " + sum.get());   //=> 15





        String line = "What is this? How are you?";
        Stream<String> wordStream = Stream.of(line.split(" "));
        int result = wordStream.reduce(0,
                (total, word) -> {
                    System.out.println("(0) total = "+total);
                    return total + word.length();
                },
                (sum1, sum2) -> {
                    System.out.println("(1) s1 = "+sum1+" ; s2 = "+sum2);
                    return sum1 + sum2;
                }
                );
        System.out.println("(2) result = "+result); //=> 21

        /*
            (0) total = 0
            (0) total = 4
            (0) total = 6
            (0) total = 11
            (0) total = 14
            (0) total = 17
            (2) result = 21
         */



        // stream -> Object[]
        wordStream = Stream.of(line.split(" "));
        String[] reverted = wordStream.toArray(String[]::new);

        // steam -> List/Set
        wordStream = Stream.of(line.split(" "));
        List<String> reverted2 = wordStream.collect(Collectors.toList());

        wordStream = Stream.of(line.split(" "));
        TreeSet<String> reverted3 = wordStream.collect(Collectors.toCollection(TreeSet<String>::new));

        // add separator
        wordStream = Stream.of(line.split(" "));
        String combined = wordStream.collect(Collectors.joining(", "));
        System.out.println("combined = "+combined);       //=> What, is, this?, How, are, you?

    }

    public static void main(String[] args) {
        ReduceDemo obj = new ReduceDemo();
        obj.foo();
    }
}
