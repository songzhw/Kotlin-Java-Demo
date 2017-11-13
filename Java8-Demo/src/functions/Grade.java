package functions;

import java.util.List;

public class Grade {
    public int id;
    public List<User> students;

    public Grade(List<User> students) {
        this.students = students;
    }
}
