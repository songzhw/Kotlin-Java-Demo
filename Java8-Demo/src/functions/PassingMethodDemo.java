package functions;

import java.util.ArrayList;
import java.util.List;

public class PassingMethodDemo {

    public Grade getGrade(){
        List<User> list = new ArrayList<>();
        list.add(new User(1, "a"));
        list.add(new User(2, "b"));
        list.add(new User(3, "c"));
        list.add(new User(4, "d"));
        list.add(new User(5, "e"));
        return new Grade(list);
    }

    public void workAll(){
        Grade grade = getGrade();
        grade.id = 100;
        List<User> students = grade.students;

        for(User user : students){
            user.id += 10;
        }

        for(User user: students){
            System.out.println("szw user = "+user);
        }

    }

    public static void main(String[] args) {
       PassingMethodDemo obj = new PassingMethodDemo();
       obj.workAll();

    }

}
