package ca.six.kjdemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


class temp {
    public static void main(String[] args) {
        Observable<Integer> ob1 = Observable.just(1, 2);
        Observable<Integer> ob2 = Observable.just(4, 5);
        ob1.join(ob2,
                integer -> Observable.just("left" + integer),
                integer -> Observable.just("right" + integer),
                (integer, integer2) -> "combine" + integer + "," + integer2
        );
    }
}





