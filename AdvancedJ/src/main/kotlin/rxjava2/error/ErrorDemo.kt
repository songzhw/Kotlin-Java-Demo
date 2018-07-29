package rxjava2.error

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.functions.Function

val DEFAULT_ERROR = 0
val DEFAULT_ERROR_100 = 100

fun main(args: Array<String>) {
    var i = 1
    val http = HttpEngine()
    http.getStoryList()
            .map { 23/0 }
            .onErrorReturn { DEFAULT_ERROR }
            .subscribe{ println("$it")}  //=> 0

    http.getStoryList()
            .map { 23/0 }
            .onErrorResumeNext(Function {Observable.just(DEFAULT_ERROR_100)})
            .subscribe{ println("$it")}  //=> 100


}

/*
onErrorResumeNext()的两种形式:


    Observable.just(23)
            .onErrorResumeNext(object : Observable<Int>() {
                override fun subscribeActual(observer: Observer<in Int>) {
                    println("onErrorResumeNext() : " + observer.toString())
                }
            })
            .subscribe { integer -> println("onNext() : " + integer!!) }

    Observable.just(23)
            .map{ 24 / 0}
            .onErrorResumeNext(Function { Observable.just(300) })
            .subscribe { integer -> println("onNext() : " + integer!!) }

 */