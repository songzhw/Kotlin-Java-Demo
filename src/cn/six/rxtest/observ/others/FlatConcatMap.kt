package cn.six.rxtest.observ

import rx.Observable

/**
 * Created by hzsongzhengwang on 2015/12/8.
 */

var origin = Observable.from(arrayListOf(2,3,4,5,6,7,8,9,10))

// uses merge() , no order
fun flatMapTest(){
    origin.flatMap { a : Int -> Observable.just(a * a)  }
        .subscribe { println("flatMapTest() $it") }
}

// uses concat, have order
fun concatMapTest(){
    origin.concatMap {  a : Int -> Observable.just(a * a)  }
            .subscribe { println("concatMapTest() $it") }
}

fun testFlatConM(args: Array<String>) {
    flatMapTest()
    println("=================")
    concatMapTest()
}