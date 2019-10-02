package generics.variant;

import generics.data.Animal;
import generics.data.Cat;
import generics.data.Dog;
import generics.data.Vegatable;

import java.util.ArrayList;
import java.util.List;

class ListVariant {
    public static void main(String[] args) {
        Vegatable cabbage = new Vegatable();
        Animal cow = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        List<? extends Animal> list = new ArrayList<>();
        list.add(cabbage);
        list.add(cow);
        list.add(cat);
        list.add(dog);
        Animal anim = list.get(0);
        Cat cat_ = list.get(1);
        list = new ArrayList<Cat>();

        List<Animal> list2 = new ArrayList<>();
        list2.add(cabbage);
        list2.add(cow);
        list2.add(cat);
        list2.add(dog);
        Animal anim2 = list.get(0);
        Cat cat2 = list2.get(1);
        list2 = new ArrayList<Cat>();

        List<?> list3 = new ArrayList<>();
        list3.add(cabbage);
        list3.add(cow);
        list3.add(cat);
        Animal animal3 = list3.get(0);
        list3 = new ArrayList<Cat>();

    }
}
