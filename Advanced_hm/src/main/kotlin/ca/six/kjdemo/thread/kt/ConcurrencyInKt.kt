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

/*
编译后:

public final class ConcurrencyInKt {
   private volatile int id = 1;


   public final synchronized void one() {
   }

   public final void two() {
      synchronized(this) {
      }
   }
}
 */