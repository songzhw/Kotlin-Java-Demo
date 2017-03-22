package ca.six.demo.lib.servicel.ifelse;

/**
 * Created by songzhw on 2017-03-22.
 */
public class OldWayDemo {
    public static void main(String[] args) {
        Student student = new Student("xl", false, 21);
        if(student.isMale){
            System.out.println(student.name + " is Male");
        } else {
            if(student.age > 18){
                System.out.println(student.name + " is legal x");
            } else {
                System.out.println(student.name + " is not legal x");
            }
        }
    }
}
