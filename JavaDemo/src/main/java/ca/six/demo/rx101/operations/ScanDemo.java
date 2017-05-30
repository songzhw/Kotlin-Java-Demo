package ca.six.demo.rx101.operations;

import io.reactivex.Observable;

public class ScanDemo {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7, 9)
                .scan((sum, item) -> sum + item)
                .subscribe((num) -> System.out.println("num = " + num));
        //=> num=1, num=4, num=9, num=16, num=25

        System.out.println("==============================");

        Observable.just(1, 3, 5, 7, 9)
                .scan(3, (sum, item) -> sum + item)
                .subscribe((num) -> System.out.println("num = " + num));
        //=> num=3, num=4, num=7, num=19, num=28
    }
}
