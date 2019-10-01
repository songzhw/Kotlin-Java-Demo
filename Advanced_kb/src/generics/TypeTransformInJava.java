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


    void main(){
        List<Being> beings = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

        testAnimals1(beings);
        testAnimals1(animals);
        testAnimals1(cats);

        testAnimals2(beings);
        testAnimals2(animals);
        testAnimals2(cats);

        testAnimals3(beings);
        testAnimals3(animals);
        testAnimals3(cats);
    }
}
