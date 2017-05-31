package ca.six.demo.lib.design.factory.dynamic;

import ca.six.demo.lib.design.factory.normal.ChicagoPizza;
import ca.six.demo.lib.design.factory.normal.NewYorkPizza;
import ca.six.demo.lib.design.factory.normal.Pizza;

public class UsPizzaFactoryService implements IPizzaFactoryService {
    @Override
    public Pizza getPizza(String type) {
        switch (type) {
            case "chicago":
                return new ChicagoPizza();
            case "NY":
                return new NewYorkPizza();
            default:
                return null;
        }
    }
}
