package ca.six.demo.lib.servicel.ifelse;

public class MaleHandler implements IStudentHandler {
    @Override
    public boolean accept(Student student) {
        return student.isMale;
    }

    @Override
    public void execute(Student student) {
        System.out.println(student.name + " is Male");
    }
}
