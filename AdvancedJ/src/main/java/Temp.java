import java.util.ArrayList;
import java.util.List;

class Dog extends Animal{}
class Cat extends Animal{}
class AdPet extends Animal{}

class Adapter {
    public void setData(List<? extends Animal> animals){
        animals.add(new AdPet());
        // ....
    }
}

public class Temp{
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());

        Adapter adapter = new Adapter();
        adapter.setData(cats);


        List<? extends Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        Animal a = animals.get(0);

    }
}