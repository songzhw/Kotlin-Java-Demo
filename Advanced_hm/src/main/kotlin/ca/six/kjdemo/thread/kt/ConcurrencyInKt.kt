package ca.six.kjdemo.thread.kt

class ConcurrencyInKt {
    @Volatile var id = 1

    @Synchronized fun one(){

    }

    fun two(){
        synchronized(this){
            //....
        }
    }
}