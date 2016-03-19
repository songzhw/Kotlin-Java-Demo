package stream;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SimpleStreamDemo {
    private List<String> words = Arrays.asList("a", "bc", "test", "home", "great");

    public static void main(String[] args) {
        SimpleStreamDemo obj = new SimpleStreamDemo();
        obj.simpleStream2();
    }

    public void simpleStream() {
        String line = "What is this? How are you?";
        Stream<String> wordStream = Stream.of(line.split(" "));
        Stream<String> someWordsStream = Arrays.stream(line.split(" "));
        Stream<String> emptyStream = Stream.empty();

        Stream<String> echos = Stream.generate( ()-> "Echo") ;
        Stream<Double> randoms = Stream.generate(Math::random);

        Stream<BigInteger> ints = Stream.iterate(BigInteger.ZERO,
                n -> n.add(BigInteger.ONE));

        Path filePath = Paths.get("E:/temp/test.xml");
        try(Stream<String> lines = Files.lines(filePath)) {
            // do with lines
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void simpleStream2() {
        words.stream()
                .filter( str -> str.length() > 2)
                .map((String str)-> str.length())
                .forEach(System.out::println);
        //=> 4, 4, 5
    }
}