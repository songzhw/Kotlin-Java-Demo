package ca.six.demo.lib.loader.servicel.d101;

import java.util.ServiceLoader;

/**
 * Created by songzhw on 2017-03-22.
 */
public class ServiceLDemo101 {
    public static void main(String[] args) {
        ServiceLoader<I101Service> serviceLoader = ServiceLoader.load(I101Service.class);
        for (I101Service service : serviceLoader) {
            service.sayHello();
        }
    }
}
