package ca.six.kjdemo.proxy;

import java.lang.annotation.*;

/*
 1. Inherited作用是，使用此注解声明出来的自定义注解，在使用此自定义注解时，如果注解在类上面时，子类会自动继承此注解. 只对类可以加这个注解
 */
@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Url {
    String value();
}

@Inherited
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface Param {
    String value();
}

@Url("http://fake.io/getUser")
interface LoginApi {
    User login(@Param("name") String name, @Param("pwd") String pwd);
}

class ApiProxy {
    public static <T> T getApi(Class<T> clazz){

    }
}

class MyRetrofitDemo {
    public static void main(String[] args) {
        LoginApi loginApi = ApiProxy.getApi(LoginApi.class);
        User user = loginApi.login("songzhw", "2003000");
        System.out.println("response = "+user);
    }
}
