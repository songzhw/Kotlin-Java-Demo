package generics.variant;

import generics.data.Animal;
import generics.data.Cat;
import generics.data.Dog;

class ArrayVariant {
    public static void main(String[] args) {
        Animal cow = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();

        Cat[] cats = new Cat[1];
        Animal[] animals = cats;
        animals[0] = dog; // no compile error, but will get a runtime error (ArrayStoreException)


    }
}
