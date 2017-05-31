package ca.six.demo.lib.design.factory.dynamic;

import ca.six.demo.lib.design.factory.normal.Pizza;

public interface IPizzaFactoryService {
    Pizza getPizza(String type);
}
