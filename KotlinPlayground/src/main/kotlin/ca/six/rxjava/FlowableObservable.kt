package ca.six.rxjava

import io.reactivex.*
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


fun observable(){
    val observable = Observable.create(ObservableOnSubscribe<Int> { e ->
        e.onNext(1)
        e.onNext(2)
        e.onComplete()
    })

    val observer = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Int) {
            println("observable: $t")
        }


        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
        }

    }

    observable.subscribe(observer)
}

fun flowable(){
    val subscriber = object: Subscriber<Int> {
        var subscription : Subscription? = null

        override fun onSubscribe(s: Subscription?) {
            this.subscription = s
            subscription?.request(1)    //request one item //没这一句,就没有事件会事件被发出来的!
        }

        override fun onNext(t: Int) {
            println("subscribe $t")
            subscription?.request(1)
        }

        override fun onComplete() {
        }

        override fun onError(t: Throwable?) {
        }


    }

    Flowable.range(0, 10)
            .subscribe(subscriber)
}

fun flow2(){
    val flow = Flowable.create(FlowableOnSubscribe<Int> { ev ->
        ev.onNext(31)
        ev.onNext(32)
        ev.onComplete()
    },  BackpressureStrategy.BUFFER)

    flow.subscribe { intNum ->
        println("$intNum")
    }

}

fun main(args: Array<String>) {
    observable()
    flowable()

}