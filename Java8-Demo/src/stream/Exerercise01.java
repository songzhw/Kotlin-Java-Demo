package stream;

import java.util.stream.Stream;

/**
 * songzhw - 2016/4/2
 * Copyright 2016 Six.
 */
public class Exerercise01 {

    // 2. Verify that asking for the first five long words does not call the filter method once the fifth long word has been found. Simply log each method call.
    public void exer02() {
        String lines = "This is a book named java 8 se for the really impatient";
        Stream<String> stream = Stream.of(lines.split(" "));
        Stream<String> newStream = stream.sorted((a, b) -> b.length() - a.length());
        newStream.limit(5)
                .forEach(str -> System.out.println(" : " + str));
    }

    // 7. Your manager asks you to write a method "public static <T> boolean isFinite(Stream<T> stream)".
    //    Why isn't that such a good idea? Go ahead and write it anyway.
    public void exer07() {
        String lines = "This is a book named java 8 se for the really impatient";
        Stream<String> stream = Stream.of(lines.split(" "));
        int ret1 = stream.mapToInt( str-> 1)
                .sum();
        System.out.println(ret1+" words"); //=> 12 words

        /*
        Stream<Double> randoms = Stream.generate(Math::random);
        double ret2 = randoms.mapToDouble(str -> 1d)
                .sum();
        System.out.println(ret2+" items"); //=> (endless loop.....)
        */
    }


    public static void main(String[] args) {
        Exerercise01 obj = new Exerercise01();
        obj.exer02();
        obj.exer07();
    }
}
