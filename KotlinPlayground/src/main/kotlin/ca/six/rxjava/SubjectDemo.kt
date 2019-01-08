package ca.six.rxjava

import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.functions.Consumer
import io.reactivex.subjects.ReplaySubject

fun be() {
    val s = BehaviorSubject.create<Int>()
    s.onNext(0)
    s.onNext(1)
    s.onNext(2)
    s.subscribe({ v -> println("Late: " + v!!) })
    s.onNext(3)
}//=> Late 2, Late 3

fun be2() {
    val s = BehaviorSubject.create<Int>()
    s.onNext(0)
    s.onNext(1)
    s.onComplete()
    s.subscribe(
            { v -> println("Late: " + v!!) },
            { err -> System.err.println("error $err") },
            { println("completed") })
}//=> completed

fun pu() {
    val subject = PublishSubject.create<Int>()
    subject.onNext(1)
    subject.subscribe(Consumer<Int> { println(it) })
    subject.onNext(2)
    subject.onNext(3)
    subject.onNext(4)
} //=> 2, 3, 4

fun re() {
    val s = ReplaySubject.create<Int>()
    s.subscribe { v -> println("Early:" + v!!) }
    s.onNext(0)
    s.onNext(1)
    s.subscribe { v -> println("Late: " + v!!) }
    s.onNext(2)
}
    /*
        Early:0
        Early:1
        Late: 0
        Late: 1
        Early:2
        Late: 2
     */

fun main(args: Array<String>) {
    pu()
    println("= = = = = = = ")
    be()
    println("= = = = = = = ")
    be2()
    println("= = = = = = = ")
    re()
}
