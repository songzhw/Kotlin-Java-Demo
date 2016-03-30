package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * songzhw - 2016/3/30
 * Copyright 2016 Six.
 */
public class GroupByDemo {

    public void foo() {
        Stream<Person> stream = PeopleRepo.getPersons().stream();
        Map<Integer, List<Person>> peopleByAge = stream.filter(p -> p.age > 21)
                .collect(Collectors.groupingBy(p -> p.age, Collectors.toList()));

        for (Map.Entry<Integer, List<Person>> entry : peopleByAge.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("entery : k = "+entry.getKey()+" ; value = [");
            for(Person p : entry.getValue()){
                sb.append(p + " ; ") ;
            }
            sb.append(" ]");
            System.out.println(sb.toString());
        }
    }
    /*  //=>
entery : k = 32 ; value = [Person{name='four', age=32} ; Person{name='five', age=32} ;  ]
entery : k = 31 ; value = [Person{name='two', age=31} ;  ]
    */

    public void boo(){
        Stream<Person> stream = PeopleRepo.getPersons().stream();
        Map<Integer, List<String>> nameByAge = stream.filter(p -> p.age > 21)
                .collect(Collectors.groupingBy( p -> p.age,
                        Collectors.mapping(p -> p.name, Collectors.toList())
                ));

        for (Map.Entry<Integer, List<String>> entry : nameByAge.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("entery : k = "+entry.getKey()+" ; value = [");
            for(String p : entry.getValue()){
                sb.append(p + " ; ") ;
            }
            sb.append(" ]");
            System.out.println(sb.toString());
        }
    }

    public void goo(){
        Stream<Person> stream = PeopleRepo.getPersons().stream();
        Map<String, Integer> sumAgeByCity = stream.collect(
                Collectors.groupingBy( p -> p.city,
                        Collectors.reducing(0, p -> p.age, Integer::sum))
        );

        for (Map.Entry<String, Integer> entry : sumAgeByCity.entrySet()) {
            System.out.println("03[city] : k = "+entry.getKey()+" ; v = "+entry.getValue());
        }
    }


    public static void main(String[] args) {
        GroupByDemo obj = new GroupByDemo();
        obj.foo();
        obj.boo();
        obj.goo();
    }
}
