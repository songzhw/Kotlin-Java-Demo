package cn.song.bcplatformtype

import rx.Observable
import java.util.*


/**
 * Created by hzsongzhengwang on 2015/9/2.
 */

/*

 --  T! means “T or T?”,
 --  (Mutable)Collection<T>! means “Java collection of T may be mutable or not, may be nullable or not”,
 --  Array<(out) T>! means “Java array of T (or a subtype of T), nullable or not”

*/

fun test(){
    /*
    // error ("Not enough information to infer paramter T in create() : rx.Observable<T!>!. Please specify it explicitly")
    var obs1  = Observable.create { subscriber -> subscriber.onNext("23") }
    */

    // correct
    var obs2 : Observable<String> = Observable.create { subscriber -> subscriber.onNext("23") }

    obs2.subscribe{str : String -> println(str)}
    //---------------------------------------------
    /** var obs3 : Observalbe<ArrayList> = Observable.create{...} is wrong, again.
     *  we must tell the compiler the T of ArrayList<T> */

    var obs3 : Observable<ArrayList<String>> = Observable.create{subscriber ->
        var list : ArrayList<String> = ArrayList()
        list.add("b12")
        list.add("a23")
        subscriber.onNext(list)
    }

    // error
//    obs3.subscribe{list : ArrayList -> println(list)}
      obs3.subscribe{list : ArrayList<String> -> println(list)}

    obs3.toSortedList()
        .subscribe{list : List<ArrayList<String>> -> println(list)}



}


fun main(args: Array<String>) {
    test()
}