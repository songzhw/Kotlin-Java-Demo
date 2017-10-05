package ca.six.klplay.advanced.delegation.lazy

class LazyDemo : Activity(){
    val textView : String by lazy{
        println("find view by id")
        findViewById(100);
    }
}

fun main(args: Array<String>) {
    val lazyDemo = LazyDemo()
    println(lazyDemo.textView)
    println("===========")
    println(lazyDemo.textView)
}

/*
//=>
    find view by id
    textView
    ===========
    textView
 */

/*
$ javap LazyDemo.class
public final class LazyDemo extends Activity {
  static final kotlin.reflect.KProperty[] $$delegatedProperties; //▼
  public final java.lang.String getTextView();
  public ca.six.kplay.delegation.LazyDemo();
  static {}; //▼
}
 */