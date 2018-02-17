package lambda;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        // 1. for(int num : numbers){ ...}的简化
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(num -> System.out.println("num = " + num)); // Android中需要minSDK >= 24, 才支持stream
        numbers.forEach(System.out::println);

        // 2. button click listener.
        /*
        原本需要
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //handle the event
            }
        });
         */
        Button btn = new Button();
        btn.addActionListener( ev -> System.out.println("click"));


        // 3. Runnable
        Thread thread = new Thread(()-> System.out.println("thread"));
        thread.start();

    }
}
