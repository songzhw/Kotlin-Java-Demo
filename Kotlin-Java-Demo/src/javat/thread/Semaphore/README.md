Suppose we have the following code:

```java
public class Foo {
    public Foo() { . . . }
    public void first() { ... }
    public void second() { ... }
    public void thirdQ { ... }
}
```

The same instance of Foo will be passed to three different threads.

ThreadA will call first, threads will call second, and threadC will call third.

Design a mechanism to ensure that first is called before second and second is called before third.
