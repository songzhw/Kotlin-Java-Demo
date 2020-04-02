package ca.six.kjdemo

open class Activity {
    open fun onCreate() {println("Activity create")}
    open fun onResume() {println("Activity resume")}
}

interface ILifecycle {
    fun onResume() {println("interface resume")}
}

class TemporaryActivity : Activity(), ILifecycle {

    override fun onCreate() {
        super.onCreate()
    }
}