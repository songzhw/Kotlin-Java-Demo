package rxjava2.error

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function

val DEFAULT_ERROR = 0

fun main(args: Array<String>) {
    var i = 1
    val http = HttpEngine()
    http.getStoryList()
            .map { 23/0 }
            .subscribe{ println("$it")}

    Observable.just(23)
            .onErrorResumeNext(object : Observable<Int>() {
                override fun subscribeActual(observer: Observer<in Int>) {
                    println("onErrorResumeNext() : " + observer.toString())
                }
            })
            .subscribe { integer -> println("onNext() : " + integer!!) }

    Observable.just(23)
            .onErrorResumeNext(Function { Observable.just(300) })
            .subscribe { integer -> println("onNext() : " + integer!!) }
}