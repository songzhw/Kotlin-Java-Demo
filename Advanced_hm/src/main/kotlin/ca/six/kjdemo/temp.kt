package ca.six.kjdemo

import io.reactivex.Observable
import io.reactivex.ObservableOperator
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.trampoline())
        .lift(Gap(20))
        .subscribe { num -> println(num) } //=> 20, 40, 60, 80, 100, 120, ...
}

class Gap(val gap: Int) : ObservableOperator<Long, Long> {
    override fun apply(observer: Observer<in Long>) = object : Observer<Long> {
        private var temp = 0L
        private lateinit var disposable: Disposable

        override fun onSubscribe(d: Disposable) {
            disposable = d
            observer.onSubscribe(d)
        }

        override fun onNext(t: Long) {
            if (disposable.isDisposed) {
                return
            }

            if (t - temp >= gap) {
                temp = t
                observer.onNext(t)
            }
        }

        override fun onError(e: Throwable) {
            if (disposable.isDisposed) {
                return
            }
            observer.onError(e)
        }

        override fun onComplete() {
            if (disposable.isDisposed) {
                return
            }
            observer.onComplete()
        }

    }

}


fun groupBy_Demo() {
    // groupBy()得到的是一个 GroupedObservable(), 所以才要后面再用flatMap()
    Observable.range(1, 8)
        .groupBy { num -> if (num % 2 == 0) "even" else "odd" }
        .filter { groupOb -> groupOb.key == "odd" }
        .flatMap { it -> it }
        .subscribe { num -> println(num) }
}
