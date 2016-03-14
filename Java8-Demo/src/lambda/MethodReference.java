package lambda;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by songzhw on 2016/3/14.
 */
public class MethodReference {

    public void foo() {
        // 1. 等于 " btn.addActionListener(event-> System.out.println(event));
        JButton btn = new JButton();
        btn.addActionListener(System.out::println);


        // 2. 对象::实例方法
        List<String> foods = Arrays.asList("Huoguo", "Sushi");
        PersonOne p = new PersonOne();
        foods.forEach(p::eat); //等于 forEach(str -> p.eat(str);)


        // 3. 类::静态方法
        btn.addActionListener(System.out::println);
        // 同样， Math::pow 等同于 (x,y) -> Math.pow(x,y)

        // 4. 类::实例方法
        int result01 = "one".compareToIgnoreCase("other");
        String[] strings = new String[]{"pear","apple"};
        Arrays.sort(strings, (x,y)-> x.compareToIgnoreCase(y)); //与下一句，是等同的效果
        Arrays.sort(strings, String::compareToIgnoreCase);      //与上一句，是等同的效果

        // 5. Constructor Method Reference
        List<String> labels = Arrays.asList("one", "two","three");
        Stream<Button> stream = labels.stream()
                .map(Button::new);
        List<Button> buttonList = stream.collect(Collectors.toList());

        Object[] roughBtns = stream.toArray();
        // or ...
        Button[] btns = stream.toArray(Button[]::new);
    }

    public static void main(String[] args) {
        MethodReference obj = new MethodReference();
        obj.foo();
    }
}

class CM {
    public void compare(CM others){
        System.out.println("compare()");
    }
}


// 6. "super" argument
class A{
    public void a(){
        System.out.println("aaa");
    }
}

class B extends A{
    public void a(){
        new Thread(super::a).start();
    }
}


