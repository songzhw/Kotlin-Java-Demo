package ca.six.demo.rx101;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class IntroductionDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int num : list) {
            if (num % 2 == 0) {
                System.out.println("num " + num);
            }
        }
        System.out.println("=========================");

        //=> 2, 4, 6
        Observable.range(1, 6)
                .filter(i -> i % 2 == 0)
                .subscribe(v -> System.out.println(v));

        System.out.println("=========================");

        // for loop --> Observable (fromIterable(), range())
        // if --> filter
        Observable.fromIterable(list)
                .filter(i -> i % 2 == 0)
                .subscribe(v -> System.out.println(v));

        System.out.println("=========================");

        // two level for loop
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("j ");
            }
            System.out.println("i");
        }

        Observable.range(0, 2)
                .doAfterNext(i -> System.out.println("i"))
                .flatMap(index -> Observable.range(0, 3))
                .doOnNext(j -> System.out.print("j-"))
                .subscribe();


    }
}
