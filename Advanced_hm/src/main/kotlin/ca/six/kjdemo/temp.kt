package ca.six.kjdemo

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit


fun main() {
    Flowable.interval(1, TimeUnit.SECONDS)

}
