package ca.six.kjdemo.proxy.retrofit;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

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

interface LoginApi {
    @Url("http://fake.io/getUser")
    User login(@Param("name") String name, @Param("pwd") String pwd);
}

class ApiProxy {
    private static final Map<Class, Object> cache = new HashMap<>();


    public static <T> T getApi(Class<T> clazz) {
        if (clazz == null || !clazz.isInterface()) {
            throw new RuntimeException("ApiProxy.getApi(arg) -- arg must be a class of interface");
        }
        Object api = cache.get(clazz);
        if (api == null) {
            api = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, (proxy, method, args) -> new User("hello"));
            cache.put(clazz, api);
        }
        return (T) api;
    }
}

class ApiCallback<T> implements InvocationHandler {

    private final Class<T> clazz;

    public ApiCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String url = "";
        Map<String, Object> params = new HashMap<>();
        // @Url修改class的就不先不管了. 现在只看@Url修饰方法的
        if (method.isAnnotationPresent(Url.class)) {
            url = clazz.getAnnotation(Url.class).value();
        }

        return HttpEngine.request(url, params, this.clazz);
    }
}

class MyRetrofitDemo {
    public static void main(String[] args) {
        LoginApi loginApi = ApiProxy.getApi(LoginApi.class);
        User user = loginApi.login("songzhw", "2003000");
        System.out.println("response = " + user);
    }
}
