package ca.six.kjdemo.proxy.mockito.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface IGreet {
    void sayHello(String name);
}


class GreetImpl implements IGreet {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}

// 原文都是使用IGreet的对象, 实为GreetImpl的对象在做事. 即IGreet obj = new GreetImpl();
// 现在要修改一些逻辑, 但不准/不能改动原有的GreetImpl. 这要怎么做?  (是的, AOP就是动态代码的应用实例之一)
//    • 方法一: 静态代理. 写一个Greet2类, 内有成员GrretImplements, 也实现IGreet.
//    • 方法二: 动态代理. 如下面的代码

// 注意, 它不是实现IGreet接口. 它是实现的InvocationHandler接口, 要实现invoke()方法
class Greet3 implements InvocationHandler {
    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;

        return Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("insert new logic here");
        System.out.println(proxy);
        Object result = method.invoke(this.delegate, args);
        return result;
    }
}


class DynamicProxyDemo2 {
    public static void main(String[] args) {
        IGreet worker = new GreetImpl();
        IGreet obj = (IGreet) new Greet3().bind(worker);
        obj.sayHello("111");
    }
}

