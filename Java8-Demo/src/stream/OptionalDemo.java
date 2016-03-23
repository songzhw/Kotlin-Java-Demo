package stream;

import java.util.Optional;

/**
 * songzhw - 2016/3/23
 * Copyright 2016 Six.
 */
public class OptionalDemo {

    public void foo(){
        // 1. create an Optional value
        Optional<Double> inversed = inverse(0.0d);
        System.out.println(inversed + " ; "+inversed.isPresent()); //=> Optional.empty ; false
        inversed = inverse(4.0d);
        System.out.println(inversed + " ; "+inversed.isPresent()); //=> Optional[0.25] ; true

        // 2. Optional.isPresenter() : return boolean
        if(inversed.isPresent()){
            System.out.println(inversed.get().toString());         //=> 0.25
        }

        // 3. Optional . ifPresenter(lambda)
        inversed.ifPresent( (Double v) -> System.out.println(v));   //=> 0.25

        // 4. Optional . flatMap()
        Optional result = Optional.of(0.25).flatMap(this::inverse).flatMap(this::sqrt);
        System.out.println("last result = "+result);                //=> Optional[2.0]

    }

    private Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1/x);
    }

    private Optional<Double> sqrt(Double y){
        return y < 0 ? Optional.empty() : Optional.of(Math.sqrt(y));
    }


    public static void main(String[] args) {
        OptionalDemo obj = new OptionalDemo();
        obj.foo();
    }

}
