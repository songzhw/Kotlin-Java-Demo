package lambda;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by songzhw on 2016/3/14.
 */
public class SimpleDemos {
    public static void main(String[] args) {
        // 1. Runnable
        new Thread(()-> System.out.println("Java8 Runnable")).start();

        // 2. click
        JButton btn = new JButton("No. 2");
        btn.addActionListener( (e)-> {
            System.out.println("Java8 Click");
        });
        System.out.println("=============");

        // 3. Collections Stream API
        List<String> langs = Arrays.asList("C","C++","Java","Python","Ruby","Groovy");
        langs.stream()
                .filter( (str)-> str.length()>3)
                .forEach(System.out::println);
        System.out.println("=============");

        List<Integer> costs = Arrays.asList(100, 150, 200, 230);
        double bill = costs.stream()
                .map( (item)-> item * 1.13)
                .reduce( (sum, item)-> sum + item)
                .get();
        System.out.println("Total = "+bill);
    }

    public void foo(int count){
        Runnable r = () -> {
//            count--; // Error!  "Variables in lambda expression should be final or effectivly final"
            System.out.println("count = "+count);
        };
    }
}
