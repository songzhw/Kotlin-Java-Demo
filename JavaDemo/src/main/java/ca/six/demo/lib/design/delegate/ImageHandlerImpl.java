package ca.six.demo.lib.design.delegate;

import java.util.concurrent.TimeUnit;

public class ImageHandlerImpl implements IImageHandler {
    @Override
    public void loadImage() {
        try {
            //用休眠2秒表示图片加载过程
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("图片加载完成。");
    }
}