package cn.six.rxtest.observ

import rx.Observable

/**
 * Created by hzsongzhengwang on 2015/12/7.
 */




fun fromTest(){

    println("=======from()==========")

    var alist = arrayListOf(2, 4, 17)
    Observable.from(alist)
        .subscribe { println(it) }//=> print three times: 2, 4, 17

    println("=======just()==========")

    Observable.just("ab","dox")
        .subscribe { println(it) } //=> print twice : "ab", "dox"

    println("=======create()==========")

    Observable.create<String>{
        it.onNext("test")
        it.onCompleted()
    }.subscribe { println(it) } //=> print once : "test"



}