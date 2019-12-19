package javaa;

import java.lang.ref.WeakReference;

public class References {
    /**weak ref: After gc determines the object is only weakly reachable*/
    public void weakRef() {
        Car car = new Car();
        WeakReference<Car> weakref = new WeakReference<>(car);
        System.out.println("compare1 ?= " + (car == weakref.get()));  //=> true

        System.gc();
        System.out.println("weak ref2 = " + weakref.get());  //=> javaa.Car@45ee12a7

        car = null;
        System.gc();
        System.out.println("weak ref3 = " + weakref.get());  //=> true
    }


    public static void main(String[] args) {
        References obj = new References();
        obj.weakRef();
    }
}

class Car {
}
