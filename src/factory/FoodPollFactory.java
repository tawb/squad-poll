package factory;
import flyweight.*;
public class FoodPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return IconFactory.get("🍔").getSymbol();
    }
}