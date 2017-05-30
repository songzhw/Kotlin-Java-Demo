package ca.six.demo.rx101.operations;

import io.reactivex.Observable;

public class GroupByDemo {
    public static void main(String[] args) {
        Observable.range(0, 4)
                .groupBy((num) -> num % 2 == 0)
                .subscribe(mapObsv -> {
                            mapObsv.subscribe(v -> {
                                System.out.println("k = " + mapObsv.getKey());
                                System.out.println("v = " + v);
                            });
                        }
                );
    }
}
//=> key = true, value = 0
//=> key = false, value = 1
//=> key = true, value = 2
//=> key = false, value = 3