package ca.six.rxjava

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableOnSubscribe
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun dispose2() {
    val flow = Flowable.create(FlowableOnSubscribe<Int> { ev ->
        ev.onNext(31)
        ev.onNext(32)
        ev.onComplete()
    }, BackpressureStrategy.BUFFER)

    val disposable = flow.map { "$it" } //转成string
            .subscribe { println(it) }

    // 但flow.subscribe(Subscriber)就是返回void. 因为在Subscriber内部已经处理了Disposable
    flow.subscribe(object : Subscriber<Int>{
        override fun onSubscribe(s: Subscription?) {}
        override fun onNext(t: Int?) {}
        override fun onComplete() {}
        override fun onError(t: Throwable?) {}
    })

}

fun main(args: Array<String>) {

}