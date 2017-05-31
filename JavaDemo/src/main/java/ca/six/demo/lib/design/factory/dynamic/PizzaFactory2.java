package ca.six.demo.lib.design.factory.dynamic;

import ca.six.demo.lib.design.factory.normal.Pizza;

import java.util.ServiceLoader;

public class PizzaFactory2 {
    public Pizza getPizza(String type) {
        ServiceLoader<IPizzaFactoryService> services = ServiceLoader.load(IPizzaFactoryService.class);
        for (IPizzaFactoryService service : services) {
            Pizza pizza = service.getPizza(type);
            if(pizza != null){
                return pizza;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PizzaFactory2 factory = new PizzaFactory2();
        System.out.println("1. "+factory.getPizza("cn"));
        System.out.println("2. "+factory.getPizza("NY"));
        System.out.println("3. "+factory.getPizza("italy"));
    }
}
