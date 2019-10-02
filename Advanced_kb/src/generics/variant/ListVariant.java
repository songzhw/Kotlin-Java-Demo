package generics.variant;

import generics.data.Animal;
import generics.data.Cat;
import generics.data.Dog;
import generics.data.Vegatable;

import java.util.ArrayList;
import java.util.List;

class ListVariant {
    public static void main(String[] args) {
        Vegatable cabbige = new Vegatable();
        Animal cow = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        List<? extends Animal> list = new ArrayList<>();
        list.add(cabbige);
        list.add(cow);
        list.add(cat);
        list.add(dog);
        Animal anim = list.get(0);
        Cat cat_ = list.get(1);
        list = new ArrayList<Cat>();

        List<Animal> list2 = new ArrayList<>();
        list2.add(cabbige);
        list2.add(cow);
        list2.add(cat);
        list2.add(dog);
        Animal anim2 = list.get(0);
        Cat cat2 = list2.get(1);

        list2 = new ArrayList<Cat>();



    }
}
