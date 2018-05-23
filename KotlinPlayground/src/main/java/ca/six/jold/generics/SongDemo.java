package ca.six.jold.generics;

import java.util.ArrayList;
import java.util.List;

public class SongDemo {
    public void cast() {
        /*
            // Error
            List<String> names = new ArrayList<>();
            List<Object> all = names;
         */



    }

    private List<Fruit> subtypes(List<? extends Fruit> sub){
        List<Fruit> all = new ArrayList<>();
        all.addAll(sub);
        return all;
    }
}



