package ca.six.kex.generics

import ca.six.jold.generics.helper.Activity

inline fun <reified T: Activity> Activity.jump(){
    startActivity(this, T::class.java)
}

/*
编译后是:
public final class ActivityExtKt {
   private static final void jump(Activity $receiver) {
      Intrinsics.reifiedOperationMarker(4, "T");
      $receiver.startActivity($receiver, Activity.class);
   }
}
 */