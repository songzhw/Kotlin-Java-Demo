package ca.six.demo.lib.servicel.ifelse;

import java.util.ServiceLoader;

public class NewWayDemo {
    public static void main(String[] args) {
        Student student = new Student("xl", true, 21);

        ServiceLoader<IStudentHandler> serviceLoader = ServiceLoader.load(IStudentHandler.class);
        for (IStudentHandler handler : serviceLoader) {
            if(handler.accept(student)){
                handler.execute(student);
            }
        }
    }
}
