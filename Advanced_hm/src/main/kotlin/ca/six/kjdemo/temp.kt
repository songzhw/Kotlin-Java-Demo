package ca.six.kjdemo

open class Activity {
    open fun onCreate() {}
    open fun onResume() {}
}

interface ILifecycle {
    fun onResume() {}
}

class TemporaryActivity : Activity(), ILifecycle {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onResume() {
        super<Activity>.onResume()
    }
}