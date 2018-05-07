package ca.six.rxjava

import io.reactivex.Flowable

fun main(args: Array<String>) {
    Flowable.just(1, 2, 3)
            .doOnCancel{ println("cancelled")}
            .take(2)
            .subscribe{ println("subscribe() $it")}
    //=> subscribe() 1;  subscribe() 2; cancelled
}