package ca.six.kjdemo.objects.inherit

open class Activity {
    open fun onCreate() {
        println("Activity create")
    }

    open fun onResume() {
        println("Activity resume")
    }
}

interface ILifecycle {
    fun onResume() {
        println("interface resume")
    }
}

class TemporaryActivity : Activity(), ILifecycle {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onResume() {
        super<ILifecycle>.onResume()
        super<Activity>.onResume()
    }
}

fun main() {
    val actv = TemporaryActivity()
    actv.onResume() //=> interface resume ; Activity resume
}