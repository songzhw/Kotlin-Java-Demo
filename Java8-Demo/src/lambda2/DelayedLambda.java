package lambda2;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * songzhw - 2016/4/3
 * Copyright 2016 Six.
 */
public class DelayedLambda {


    public static void main(String[] args) {
        DelayedLambda obj = new DelayedLambda();
        obj.foo1();
        obj.foo2();

    }

    // 1. delay execution
    private void foo1() {
        repeat(3, (Integer num) -> System.out.println("szw : "+num));  //=> 0, 1, 2
    }

    private void repeat(int n, Consumer<Integer> c){
        for(int i = 0 ; i < n ; i++) {
            c.accept(i);
        }
    }

    // 2.
    private void foo2(){
        Image img = new Image("res/kitty.jpg");
        Image brightImage = transform(img, Color::brighter);
    }

    private Image transform(Image src, UnaryOperator<Color> func){
        int width = (int) src.getWidth();
        int height = (int) src.getHeight();

        WritableImage ret = new WritableImage(width, height);
        PixelWriter pixelWriter = ret.getPixelWriter();

        for(int x = 0 ; x < width ; x++){
            for(int y = 0 ; y < height; y++){
                Color newColor = func.apply(src.getPixelReader().getColor(x, y));
                pixelWriter.setColor(x, y, newColor);
            }
        }

        return ret;
    }
}
