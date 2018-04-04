package ca.six.demo.collections;

import ca.six.demo.collections.priority_queue.Request;

import java.util.ArrayList;
import java.util.List;

public class RemoveDemo {
    public static void main(String[] args) {
        List<Request> list = new ArrayList<>();
        Request req1 = new Request("a","3");
        Request req2 = new Request("a","4");
        Request req3 = new Request("a","3");
        list.add(req1);
        list.add(req1);
        list.add(req2);
        list.add(req3);
        list.add(req1);

        for(Request req : list){
            System.out.println("szw req = "+req);
        }

        System.out.println("==================================");

        list.remove(req1); //Removes the first occurrence of the specified element from this list
        for(Request req : list){
            System.out.println("szw req = "+req);
        }

    }
}
