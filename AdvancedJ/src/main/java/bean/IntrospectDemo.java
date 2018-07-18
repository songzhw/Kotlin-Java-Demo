package bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;

public class IntrospectDemo {
    public static void main(String[] args) throws Exception {
        Student student = new Student(23, "szw", true, "gaoke");
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class, User.class);

        System.out.println("=============== Properties ===============");
        PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor p : props) {
            System.out.println("szw: " + p.getName() + " = " + p.getReadMethod().invoke(student));
            // 若函数是private方法, 那可以使用反射的p.getReadMethod().setAccessible(true);
        }

        System.out.println("=============== Methods ");
        MethodDescriptor[] methods = beanInfo.getMethodDescriptors();
        for(MethodDescriptor md : methods){
            System.out.println("szw: "+md.getName());
        }

    }
}




