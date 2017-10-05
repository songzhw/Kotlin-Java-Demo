package ca.six.klplay.biz.observe


import java.util.*

class Watcher03 : Observer {
    init{
        LoginObservable.addObserver(this)
    }

    override fun update(o: Observable, arg: Any) {
        println("szw watcher03 : detect (${arg as LoginState})")
    }
}