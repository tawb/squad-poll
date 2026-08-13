package factory;

public class CoffeePollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return "☕";
    }
}