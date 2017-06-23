package ca.six.klplay.advanced.extension

fun String.first(num: Int): String {
    return this.substring(0, num);
}

fun main(args: Array<String>) {
    println("test".first(2))
}

/*
What is this kotlin file after being compiled?
```
public final class ca.six.kdemo.advanced.extension.FunctionExtensionDemoKt {
  public static final java.lang.String first(java.lang.String, int);
  public static final void main(java.lang.String[]);
}
```
*/


