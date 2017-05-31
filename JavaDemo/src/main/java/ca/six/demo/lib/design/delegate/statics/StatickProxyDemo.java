package ca.six.demo.lib.design.delegate.statics;

import ca.six.demo.lib.design.delegate.IImageHandler;
import ca.six.demo.lib.design.delegate.ImageHandlerImpl;

public class StatickProxyDemo {
    public static void main(String[] args) {
        IImageHandler handler = new ImageHandlerImpl();
        ImageHandlerProxy proxy = new ImageHandlerProxy(handler);
        proxy.loadImage();
    }
}

/*
请等待，正在加载图片
图片加载完成。
 */