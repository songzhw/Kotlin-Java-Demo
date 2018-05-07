package ca.six.rxjava

import io.reactivex.Maybe

fun isLogin() : Boolean{
    val random : Int = (Math.random()*100).toInt()
    println("random = $random")
    return random %2 == 0
}

fun main(args: Array<String>) {
    Maybe.just(isLogin())
            .subscribe({ isLogin ->
                println("maybe : $isLogin")
            })
}