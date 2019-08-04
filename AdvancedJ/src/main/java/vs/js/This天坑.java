package vs.js;

import java.util.function.Consumer;

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

public class This天坑 {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        obj2.hello = obj1.hello;
        obj2.hello.accept(20); //=> 20: Hello Apple
    }
}

/*
[js]
let obj1 = {
  name: "apple",
  hello: function() {
    console.log(`hello, ${this.name}`);
  }
};

let obj2 = {
  name: "banana",
  hello: obj1.hello
};

obj1.hello();  //=> hello, apple
obj2.hello();  //=> hello, banana
 */