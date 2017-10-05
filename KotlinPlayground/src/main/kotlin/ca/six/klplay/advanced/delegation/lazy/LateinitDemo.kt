package ca.six.klplay.advanced.delegation.lazy

class LazyInitDemo : Activity(){
    lateinit var textView : String
}

fun main(args: Array<String>) {
    val demo = LazyInitDemo()
//    println("${demo.textView}")   //=> NPE crash
    demo.textView="23"
    println("${demo.textView}")
}

/*
//=> .class
public final class LazyInitDemo extends Activity {
  public String textView;

  public final void setTextView(@NotNull String <set-?>) {
    this.textView = <set-?>;
  }

  public final String getTextView() {
    String tmp4_1 = this.textView;
    if (tmp4_1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textView");
    }
    return tmp4_1;
  }
}


 */