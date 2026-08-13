package factory;

public class MallPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return "🛍️";
    }
}