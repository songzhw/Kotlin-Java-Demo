package ca.six.kjdemo.rxjava

import ca.six.kjdemo.Pair
import io.reactivex.Flowable


fun main() {
    Flowable.range(1, 3)
        .flatMap(
            { x -> Flowable.just(x + 10) },
            { orig, now -> Pair.create(orig, now) }
        )
        .subscribe { x -> println(x) }
    /*
        Pair{first=1, second=11}
        Pair{first=2, second=12}
        Pair{first=3, second=13}
     */
}