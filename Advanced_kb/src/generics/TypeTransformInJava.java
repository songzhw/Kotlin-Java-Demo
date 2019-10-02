package generics;

import java.util.ArrayList;
import java.util.List;

class Being{}
class Animal extends Being{}
class Cat extends Animal{}

class TypeTransformInJava {
    void testAnimals1(List<Animal> list){ }
    void testAnimals2(List<? extends Animal> list){ }
    void testAnimals3(List<? super Animal> list){ }

    void testAnimalA(Animal animal){}


    void main(){
        List<Being> beings = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

//        testAnimals1(beings);
        testAnimals1(animals);
//        testAnimals1(cats);

//        testAnimals2(beings);
        testAnimals2(animals);
        testAnimals2(cats);

        testAnimals3(beings);
        testAnimals3(animals);
//        testAnimals3(cats);

//        testAnimalA(new Being());
        testAnimalA(new Animal());
        testAnimalA(new Cat());

        List<? extends Animal> list = new ArrayList<>();
//        list.add(new Cat());
//        list.add(new Animal());
//        list.add(new Being());
        Animal anim = list.get(0);

        List<? super Animal> list2 = new ArrayList<>();
        list2.add(new Cat());
        list2.add(new Animal());
        list2.add(new Being());
        Animal anim2 = list2.get(0);
    }
}
