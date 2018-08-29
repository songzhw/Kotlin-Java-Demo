package bean;

public class Student extends User {
    private String school;

    public Student(long id, String name, boolean isMale, String school) {
        super(id, name, isMale);
        this.school = school;
    }


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}