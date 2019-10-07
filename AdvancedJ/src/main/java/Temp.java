import java.util.ArrayList;
import java.util.List;

class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

class Adapter {
    public void setData(List<? extends Animal> animals){
    }
}

public class Temp{
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        Adapter adapter = new Adapter();
        adapter.setData(cats);


    }
}