package ca.six.klplay.biz.observe

import java.util.*

class Watcher01 : Observer {
    init{
        LoginObservable.addObserver(this)
    }

    override fun update(o: Observable, arg: Any) {
        println("szw watcher01 : detect (${arg as LoginState})")
    }
}