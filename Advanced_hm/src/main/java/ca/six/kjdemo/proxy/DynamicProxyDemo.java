package ca.six.kjdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

interface IService {
    String getUser(int id);
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        DynamicProxyDemo obj = new DynamicProxyDemo();
        obj.proxy(20);
    }

    public void proxy(int id) {
        InvocationHandler handler = (proxy, method, args) -> {
            System.out.println(method);
            if (method.getName().equals("getUser")) {
                return "user" + method.getParameters()[0];
            }
            return null;
        };

        IService service = (IService) Proxy.newProxyInstance(
                IService.class.getClassLoader(),
                new Class[]{IService.class},
                handler);
        String ret = service.getUser(id);
        System.out.println(ret);
    }
}
