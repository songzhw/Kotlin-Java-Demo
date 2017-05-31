package ca.six.demo.lib.design.delegate.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object subject;

    //通过构造函数传入实际对象实例
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置工作");
        Object result = method.invoke(subject, args);
        System.out.println("收尾工作");
        return result;
    }
}