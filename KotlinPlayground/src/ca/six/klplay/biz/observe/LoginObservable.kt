package ca.six.klplay.biz.observe

import java.util.*

// singleton
object LoginObservable : Observable() {

    fun notifyStateChanged(newState: LoginState) {
        setChanged()
        notifyObservers(newState)
    }

}