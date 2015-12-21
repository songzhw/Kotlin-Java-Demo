package cn.six.rxtest.observ

import rx.Observable
import kotlin.properties.Delegates

// 使用RxJava实现延迟订阅 (Deferring Observable code until subscription in RxJava)
// http://blog.danlew.net/2015/07/23/deferring-observable-code-until-subscription-in-rxjava/

class DeferEntity{
    var value = "original"

    fun giveValue(v : String){
        value = v
    }

    fun valueObserv() : Observable<String>{
        return Observable.just(value);
    }

    fun observCreate() : Observable<String>{
        return Observable.create<String>{
            it.onNext(value)
            it.onCompleted()
        }
    }

    fun observDefer() : Observable<String> {
        return Observable.defer { Observable.just(value)  }
    }
}


fun testDefer(args: Array<String>) {
    var instance = DeferEntity()
    var oValue = instance.valueObserv()
    instance.giveValue("23")
    oValue.subscribe{ println("$it")} // original

    var instance2 = DeferEntity()
    var oValue2 = instance2.observCreate()
    instance2.giveValue("34")
    oValue2.subscribe{ println("$it")} // 34

    var instance3 = DeferEntity()
    var oValue3 = instance3.observDefer()
    instance3.giveValue("25")
    oValue3.subscribe{ println("$it")} // 25
}


/*
使用defer()操作符的唯一缺点就是，每次订阅都会创建一个新的Observable对象。
create()操作符则为每一个订阅者都使用同一个函数，所以，后者效率更高。
*/