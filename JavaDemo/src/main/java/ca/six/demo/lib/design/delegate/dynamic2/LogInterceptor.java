package ca.six.demo.lib.design.delegate.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInterceptor implements InvocationHandler {//注意实现这个Handler接口
    private Object target;//目标对象的引用，这里设计成Object类型，更具通用性 
 
    public LogInterceptor(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
        System.out.println("Entered " + target.getClass().getName() + "-" + method.getName() + "}");
        Object result = method.invoke(target, arg);//调用目标对象的方法 
         System.out.println("Before return: " + result);
        return result;
    }
} 