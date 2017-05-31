package ca.six.demo.lib.design.delegate.dynamic;

import ca.six.demo.lib.design.delegate.IImageHandler;
import ca.six.demo.lib.design.delegate.ImageHandlerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
    public static void main(String[] args) {

        //真实对象
        IImageHandler realObject = new ImageHandlerImpl();

        //代理对象的处理器
        InvocationHandler handler = new DynamicProxy(realObject);

        //生成代理对象
        ClassLoader classLoader = handler.getClass().getClassLoader();
        IImageHandler imageProxy = (IImageHandler)Proxy.newProxyInstance(classLoader,
            new Class[] { IImageHandler.class }, handler);

        imageProxy.loadImage();
    }
}