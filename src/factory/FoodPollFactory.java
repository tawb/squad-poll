package factory;

public class FoodPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return "🍔";
    }
}