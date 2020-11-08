package ca.six.kjdemo.rxjava

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


var isMemoryCached = true;
var isDiskCached = false;
var isNetworkCached = false;


var memoryCache = Observable.create<String> {
    if (isMemoryCached) { // if(memoryCache.isNotEmpty())
        it.onNext("cache from memory")
    } else {
        it.onComplete()
    }
}
var diskCache = Observable.create<String> {
    if (isDiskCached) {
        it.onNext("cache from disk")
    } else {
        it.onComplete()
    }
}
var networkCache = Observable.just("Get data from server")


fun getImage() {
    Observable.concat(memoryCache, diskCache, networkCache)
        .subscribe { it ->
            println("szw get value : $it")
        }
}

fun main() {
    getImage()
}