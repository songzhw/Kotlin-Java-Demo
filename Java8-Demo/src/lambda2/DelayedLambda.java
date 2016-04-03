package lambda2;

import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * songzhw - 2016/4/3
 * Copyright 2016 Six.
 */
public class DelayedLambda {


    public static void main(String[] args) {
        DelayedLambda obj = new DelayedLambda();
        obj.foo1();
        obj.foo4();

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
        // p.s. : public Color brighter()
    }

    // UnaryOperator : public T apply(T)
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

    // 3. Compose
    public Image foo3(){
        Image img = new Image("res/kitty.jpg");
        Image brightImage = transform(img, Color::brighter);
        Image finalImage = transform(brightImage, Color::grayscale);
        return finalImage;
    }

    // 3. An more efficient Compose (to reduce the temporary, hug Image in the memory)
    public Image foo3_2(){
        Image img = new Image("res/kitty.jpg");
        Image ret = transform(img,
                compose(Color::brighter, Color::grayscale));
        return ret;
    }

    public <T>  UnaryOperator<T> compose(UnaryOperator<T> op1, UnaryOperator<T> op2) {
        return t -> op2.apply( op1.apply(t) );
    }

    //4. confused about the foo2()
    class Car{
        public String name;
        public Car(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Car{" + "name='" + name + '\'' + '}';
        }

        public Car polish(){
            Car car = new Car("polished: " + this.name);
            return car;
        }

        public Car transfer(Car old){
            Car other = new Car("new car [from "+old.name+"]");
            return other;
        }

    }

    public void foo4(){
        Car car = new Car("royal");
        test4(car::polish, car::transfer);
        test4(car::polish, Car::polish);
    }

    public void test4(Supplier<Car> supplier, UnaryOperator<Car> func){
        // [Supplier] T get()
        // [UnaryOperator] T apply(T t)

        Car car2 = supplier.get();
        System.out.println("foo4(1) : "+car2);       //=> foo4(1) : Car{name='polished: royal'}
        Car newCar = func.apply(car2);
        System.out.println("foo4(2) : "+newCar);     //=> foo4(2) : Car{name='new car [from polished: royal]'}
    }



}
