package ca.six.demo.lib.design.delegate.dynamic2;

import ca.six.demo.lib.design.delegate.IImageHandler;
import ca.six.demo.lib.design.delegate.ImageHandlerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicDemo2 {
    public static void main(String[] args) {
        IImageHandler realObject = new ImageHandlerImpl();
        InvocationHandler handler = new LogInterceptor(realObject);

        ClassLoader classLoader = handler.getClass().getClassLoader();
        IImageHandler imageProxy = (IImageHandler)Proxy.newProxyInstance(classLoader,
            new Class[] { IImageHandler.class }, handler);

        imageProxy.loadImage();
    }
}
/*
Entered ca.six.demo.designpattern.proxy.ImageHandlerImpl-loadImage}
图片加载完成。
Before return: null
 */