package ca.six.demo.lib.design.factory.dynamic;

import ca.six.demo.lib.design.factory.normal.ChinesePizza;
import ca.six.demo.lib.design.factory.normal.Pizza;

public class CnPizzaFactoryService implements IPizzaFactoryService {
    @Override
    public Pizza getPizza(String type) {
        if (type.equals("cn")) {
            return new ChinesePizza();
        }
        return null;
    }
}
