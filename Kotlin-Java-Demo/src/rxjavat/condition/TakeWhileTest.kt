package cn.six.rxtest.observ

import rx.Observable

/**
 * Created by hzsongzhengwang on 2015/12/21.
 */

fun takeWhileTest(){
    Observable.from(arrayListOf(1,2,3,4,5,6,7))
            .takeWhile { it % 2 == 1 }
            .subscribe{ println("szw $it")}  //=>1

    println ("===========")

    Observable.from(arrayListOf(1,2,3,4,5,6,7))
            .filter { it % 2 == 1 }
            .subscribe{ println("szw $it")} //=>1 3 5 7
}

