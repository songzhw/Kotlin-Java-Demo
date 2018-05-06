package ca.six.rxjava

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

//internal class RpSubscriber<T> : Subscriber<T>() {
//
//    override fun onStart() {
//        request(1)  // request 1 element to the upstream
//    }
//
//    override fun onNext(t: T) {
//        // TODO do something
//        // after handle one event, it's ready for another one event
//        request(1)
//    }
//
//    override fun onComplete() {
//        // ...
//    }
//
//    override fun onError(t: Throwable?) {
//        // ...
//    }
//}
//
//fun main(args: Array<String>) {
//    Observable.range(1, 90011)
//            .observeOn(Schedulers.newThread())
//            .subscribe(RpSubscriber<Int>())
//}
