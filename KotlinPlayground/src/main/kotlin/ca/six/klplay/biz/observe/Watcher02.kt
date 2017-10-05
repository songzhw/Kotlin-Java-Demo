
package ca.six.klplay.biz.observe

import java.util.*

class Watcher02 : Observer {
    init{
        LoginObservable.addObserver(this)
    }

    override fun update(o: Observable, arg: Any) {
        println("szw watcher02 : detect (${arg as LoginState})")
    }
}