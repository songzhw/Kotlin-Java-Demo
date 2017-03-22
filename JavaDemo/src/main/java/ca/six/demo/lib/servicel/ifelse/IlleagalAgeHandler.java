package ca.six.demo.lib.servicel.ifelse;

public class IlleagalAgeHandler implements IStudentHandler {
    @Override
    public boolean accept(Student student) {
        return student.age <= 18;
    }

    @Override
    public void execute(Student student) {
        System.out.println(student.name + " is not legal x");
    }
}