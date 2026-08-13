package factory;

public class WalkPollFactory extends PollFactory {
    @Override
    protected String categoryPrefix() {
        return "🚶";
    }
}