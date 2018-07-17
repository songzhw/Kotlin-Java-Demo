package tmp;


import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class IntrospectDemo {
    public static void main(String[] args) throws Exception {
        Student student = new Student(23, "szw", true, "gaoke");
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);

        System.out.println("=============== Properties ===============");
        PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor p : props) {
            System.out.println("szw: " + p.getName() + " = " + p.getReadMethod().invoke(student));
        }

        System.out.println("=============== Methods ");
        MethodDescriptor[] methods = beanInfo.getMethodDescriptors();
        for(MethodDescriptor md : methods){
            System.out.println("szw: "+md.getName());
        }

    }
}


class User {
    private long id;
    private String name;
    private boolean isMale;

    public User(long id, String name, boolean isMale) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}

class Student extends User {
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
