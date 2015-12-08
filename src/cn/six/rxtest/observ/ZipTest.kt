package cn.six.rxtest.observ

import rx.Observable
import rx.functions.Action1
import rx.functions.Func2
import rx.functions.Func3
import java.util.*

/**
 * Created by hzsongzhengwang on 2015/12/4.
 */

// wait all the observable finishes , then zip
var api3 = Observable.create<String> {
    var da = Date()
    println("api3() ${da.minutes}:${da.seconds}")
    try {
        Thread.sleep(2000);
    } catch(e: Exception) {
    }
    it.onNext("access api one")
}

var api4 = Observable.create<String> {
    var da = Date()
    println("api4() ${da.minutes}:${da.seconds}")
    try {
        Thread.sleep(1000);
    } catch(e: Exception) {
    }
    it.onNext("access api two")
}

fun zipTest(){
    var da = Date()
    println("zipTest() ${da.minutes}:${da.seconds}")
    Observable .zip(api3, api4) {s1 : String, s2:  String->
                        da = Date()
                        println("zipTest() func2($s1, $s2) -- ${da.minutes}:${da.seconds}")
                        "[--$s1 || $s2--]"  // last code is a "return" code
                 }
            .subscribe {
                println("szw $it")
            }
}

fun main(args: Array<String>) {
    zipTest()
}

/*

result : wait all the observable finishes , then zip

zipTest() 30:29
api3() 30:29
api4() 30:31
zipTest() func2(access api one, access api two) -- 30:32
szw [access api one || access api two]


 */