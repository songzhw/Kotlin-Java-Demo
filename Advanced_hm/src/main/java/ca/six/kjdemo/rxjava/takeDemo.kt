package ca.six.kjdemo.rxjava

import io.reactivex.Flowable
import io.reactivex.Observable

fun main() {
    Flowable.range(1, 5)
        .takeWhile { x -> x > 3 }
        .subscribe(System.out::println) //空数据, 因为一开始就不符合条件嘛

    Flowable.range(1, 5)
        .takeUntil { x -> x > 3 }
        .subscribe(System.out::println) //1,2,3,4

}