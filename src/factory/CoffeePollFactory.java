package factory;
import flyweight.*;
public class CoffeePollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return IconFactory.get("☕").getSymbol();
    }
}