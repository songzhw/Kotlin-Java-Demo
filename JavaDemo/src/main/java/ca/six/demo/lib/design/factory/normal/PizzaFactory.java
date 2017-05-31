package ca.six.demo.lib.design.factory.normal;

public class PizzaFactory {
    public static Pizza getPizza(String type) {
        switch (type) {
            case "chicago":
                return new ChicagoPizza();
            case "NY":
                return new NewYorkPizza();
            case "cn":
                return new ChinesePizza();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(" --> "+PizzaFactory.getPizza("cn"));
    }
}
