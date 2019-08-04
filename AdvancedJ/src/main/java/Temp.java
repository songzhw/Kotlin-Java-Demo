import java.io.RandomAccessFile;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

class A {
    public String name = "Apple";
    public Consumer<Integer> hello;

    public A() {
        hello = (Integer it) -> System.out.println(it + ": Hello " + this.name);
    }
}

class B {
    // 无法使用 private Consumer hello = A.hello ;  因为A中没有一个static方法叫Hello
    public String name = "Banana";
    public Consumer<Integer> hello;
}


public class Temp {
    public static void unlikeJavascript() {
        A obj1 = new A();
        B obj2 = new B();
        obj2.hello = obj1.hello;
        obj2.hello.accept(20); //=> 20: Hello Apple
    }

    public void is2Power(int n){
        if ((n & (n - 1)) == 0) {
            System.out.println("if");
        }
    }


    public static void main(String[] args) {
        System.out.println(32 << 2); //=> 128

        System.out.println(32 >> 2); //=> 8
        System.out.println(32 >>> 2);//=> 8

        // >>> 无符号右移
        System.out.println(-32 >> 2); //=> -8
        System.out.println(-32 >>> 2);//=> 1073741816


    }
}








