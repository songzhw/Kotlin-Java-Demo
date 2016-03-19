package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by songzhw on 2016/3/19.
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        ParallelStreamDemo obj = new ParallelStreamDemo();

    }

    private List<String> words = Arrays.asList("a", "bc", "test", "home", "great");

    public void parallelStream() {
        Stream<String> newWords = words.parallelStream().distinct();

    }
}
