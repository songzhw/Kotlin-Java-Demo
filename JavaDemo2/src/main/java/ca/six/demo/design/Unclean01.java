package ca.six.demo.design;

public class Unclean01 {
    public void animalSound(Object anim){
        if(anim instanceof Cat){
            ((Cat)anim).sound();
        } else if(anim instanceof Dog){
            ((Dog)anim).sound();
        }
    }
}



interface IAnimal {
    void sound();
}
class Cat implements IAnimal {
    @Override
    public void sound() {
        System.out.println("meow");
    }
}
class Dog implements IAnimal {
    @Override
    public void sound() {
        System.out.println("bark");
    }
}
