package ca.six.demo.lib.design.delegate.statics;

import ca.six.demo.lib.design.delegate.IImageHandler;

public class ImageHandlerProxy implements IImageHandler {
    private IImageHandler imageHandler;

    //将真实对象通过构造器传过来
    public ImageHandlerProxy(IImageHandler imageHandler) {
        this.imageHandler = imageHandler;
    }

    @Override
    public void loadImage() {
        //代理做一些预处理
        System.out.println("请等待，正在加载图片");

        //调用真实对象方法
        imageHandler.loadImage();

        //可以做一些收尾工作
    }
}