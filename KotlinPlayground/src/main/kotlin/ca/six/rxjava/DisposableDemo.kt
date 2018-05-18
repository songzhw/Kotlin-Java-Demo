package ca.six.rxjava

import io.reactivex.*
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun dispose2() {
    val flow = Flowable.create(FlowableOnSubscribe<Int> { emitter ->
        emitter.onNext(31)
        emitter.onNext(32)
        emitter.onComplete()
    }, BackpressureStrategy.BUFFER)

    val disposable = flow.map { "$it" } //转成string
            .subscribe { println(it) }
}

fun dispose1(){
    val obs = Observable.create(ObservableOnSubscribe<Int> {emitter ->
        emitter.onNext(23)
        emitter.onNext(33)
        emitter.onComplete()
    })

    obs.subscribe(object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {}
        override fun onNext(integer: Int) {}
        override fun onError(e: Throwable) {}
        override fun onComplete() {}
    })
}

fun main(args: Array<String>) {

}