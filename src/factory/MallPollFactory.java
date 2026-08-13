package factory;
import flyweight.*;
public class MallPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return IconFactory.get("🛍️").getSymbol();
    }
}