package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * songzhw - 2016/3/28
 * Copyright 2016 Six.
 */
public class CollectDemo {

    public void foo(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5).filter(p -> p > 2);
        List<Integer> result = stream.collect(
                () -> new ArrayList<>(),
                (list, item) -> list.add(item),
                (one, two) -> one.addAll(two)
        );
        for(Integer i : result){
            System.out.println("szw : "+i);
        } //=> 3, 4, 5

        // equals :
//        List<Integer> sameResult = stream.collect(Collectors.toList());

        // also equals:
//        List<Integer> sameResult2 = stream.collect(ArrayList::new, List::add, List::addAll);
    }

    public void collectInfosToMap(){
        Stream<Person> stream = PeopleRepo.getPersons().stream();
        Map<String, Integer> result = stream.collect(
                HashMap::new,
                (map, person) -> map.put(person.name, person.age),
                (one, two) -> one.putAll(two)
        );

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println("entery : k = "+entry.getKey()+" ; v = "+entry.getValue());
        }

        // equals:
//        Map<String, Integer> sameResult = stream.collect(
//                Collectors.toMap(p -> p.name, p -> p.age, (existed, newed) -> newed)
//        );

    }

    public static void main(String[] args) {
        CollectDemo obj = new CollectDemo();
        obj.foo();
        obj.collectInfosToMap();
    }
}
